package project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import project.vo.BuyVo;
import project.vo.CustomerBuyVo;

public class TblBuyDao {
    
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    //executeUpdate 메소드는 insert,update,delete 가 정상 실행(반영되 행 있으면)되면 1을 리턴, 
    //                       특히 update, delete 는 조건에 맞는 행이 없어서 반영된 행이 없으면 0을 리턴. 
    //구매하기
    public int insert(BuyVo vo){
        // 할일1 : SQL 작성하기 (매개변수 표시 정확히 합시다.)
        String sql="INSERT INTO TBL_BUY \r\n" + 
                "VALUES (buy_pk_seq.nextval, ?,?,?,sysdate)";
        int result=0;                
        try (Connection connection = getConnection();       //auto close
            PreparedStatement pstmt = connection.prepareStatement(sql);)
            {   
                //할일2 : 매개변수 바인딩 (매개변수 타입에 맞는 메소드를 실행합시다.)
               pstmt.setString(1, vo.getCustomId());
               pstmt.setString(2, vo.getPcode());
               pstmt.setInt(3, vo.getQuantity());
               result= pstmt.executeUpdate();
        } catch (SQLException e) {
            //customid 와 pcode 는 참조테이블에 존재하는 값이 아니면 무결성 위반 오류
            System.out.println("구매하기 실행 예외 발생 : " + e.getMessage());
        }//close는 자동으로 합니다. finally 없음
        return result;
    }

    //구매 수량 수정 - PK 는 행 식별합니다. 특정 행을 수정하려면 where 조건컬럼은 buy_idx(PK) 
    public int modify(Map<String,Integer> arg){  //(BuyVo vo) {  //인자를 Map 으로 변경했습니다.
        int result=0;
        String sql=  "UPDATE tbl_buy " + 
                "SET QUANTITY = ? " + 
                "WHERE BUY_IDX = ?";
        try (Connection connection = getConnection();       //auto close
            PreparedStatement pstmt = connection.prepareStatement(sql);)
            {   //매개변수 바인딩
                pstmt.setInt(1, arg.get("quantity"));
                pstmt.setInt(2, arg.get("buyidx"));
                result = pstmt.executeUpdate();          //실행
                //buy_idx 컬럼에 없는 값이면 오류는 아니고 update 반영한 행의 개수가 0입니다.
        } catch (SQLException e) {
            System.out.println("구매수량 변경 실행 예외 발생 : " + e.getMessage());
        }
        return result;
    }
    //구매 취소 - PK 는 행 식별합니다. 특정 행을 삭제하려면 where 조건컬럼은 buy_idx(PK) 
    public int delete(int buyIdx) {
        int result=0;
        String sql=  "DELETE FROM tbl_buy \r\n" + //
                "WHERE BUY_IDX=?";
        try (
            Connection connection = getConnection();       //auto close
            PreparedStatement pstmt = connection.prepareStatement(sql);
        )
            {   
                //매개변수 바인딩
                pstmt.setInt(1, buyIdx);
                result = pstmt.executeUpdate();
                 //buy_idx 컬럼에 없는 값이면 오류는 아니고 update 반영한 행의 개수가 0입니다.
        } catch (SQLException e) {
            System.out.println("구매취소 실행 예외 발생 : " + e.getMessage());
        }
        return result;
    }

    //mypage 기능의 메소드. 
    public List<CustomerBuyVo> selectCustomerBuyList(String customerid) {
        List<CustomerBuyVo> list = new ArrayList<>();
        String sql ="SELECT BUY_IDX ,tb.PCODE , PNAME, PRICE, QUANTITY ,BUY_DATE  \r\n" + //
                "FROM TBL_BUY tb \r\n" + //
                "JOIN TBL_PRODUCT tp \r\n" + //
                "ON tb.PCODE = tp.PCODE \r\n" + //
                "WHERE tb.CUSTOMID =? \r\n" + //
                "ORDER BY BUY_DATE DESC";
        try(
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql))
		{
            ps.setString(1, customerid);
		    ResultSet rs = ps.executeQuery();
		
		    while(rs.next()) {
			    list.add(new CustomerBuyVo(rs.getInt(1), 
					rs.getString(2), 
					rs.getString(3), 
					rs.getInt(4),
					rs.getInt(5),
                    rs.getTimestamp(6)));
		    }
        }catch(SQLException e){
            System.out.println("고객별 구매내역 실행 예외 발생 : " + e.getMessage());
        }
		return list;
	}
    //장바구니 모두 구매
    // ㄴbatch (배치) 는 일괄처리 : 실행할 insert, update, delete 등의 데이터 저장 DML을 여러개 모아 두었다가
    //                              한번에 실행시킵니다.
    // ㄴ트랜잭션 : 특정 요구사항에 대한 `하나의 기능`을 실행할 `여러 SQL 명령들`로 구성된 `작업단위`
    //          ㄴ 예시 : cart 에 저장된 상품 중 하나라도 참조값이 없는 pcode 가 있으면 rollback, 모두 정상이면 commit
    //                    트랜잭션 commit 모드가 auto 에서 수동으로 변경.
    public int insertMany(List<BuyVo> cart) {       // 여러번(cart 크기)의 insert 를 실행합니다.
        String sql="INSERT INTO TBL_BUY \r\n" +     //위의 insert 복붙하세요. 
                "VALUES (buy_pk_seq.nextval, ?,?,?,sysdate)";
        Connection connection = null;
        PreparedStatement pstmt = null;
        int count = 0;
         try{       
            connection = getConnection();       
            pstmt = connection.prepareStatement(sql);
            connection.setAutoCommit(false);        //※ auto 커밋 해제
             for(BuyVo vo : cart)
             {  
               pstmt.setString(1, vo.getCustomId());
               pstmt.setString(2, vo.getPcode());
               pstmt.setInt(3, vo.getQuantity());
               pstmt.addBatch();                    
               //※ sql 을 메모리에 모아두기. insert sql 에 대입되는 매개변수값은 매번 다릅니다.
                count++;
             }
             pstmt.executeBatch();              //※ 모아둔 sql 을 일괄 실행하기. 실행 중에 무결성 오류 생기면
             connection.commit();               //      catch 에서 rollback
        } catch (SQLException e) {      //예외발생 : 트랜잭션 처리
            try {
                connection.rollback();
            } catch (SQLException e1) {   }
            count=-1;
            System.out.println("구매 불가능한 상품이 있습니다.");
            System.out.println("장바구니 구매 실행 예외 발생 : " + e.getMessage());
        }finally {              //정상실행과 예외 모두에 대해 자원 해제
            try{                //트랜잭션 처리를 위해 connection 을 사용해야 하므로 직접 close 했습니다.
                pstmt.close();
                connection.close();
            }catch (SQLException e1) {   } 
        }
        return count;

    }

    public int money_of_dayByCustomer(String customid,String buydate){
        String sql = "{ call money_of_day(?,?,?) }";
        int money=0;
        try (
            Connection connection = getConnection();
            CallableStatement cstmt = connection.prepareCall(sql)
            ) {
            //프로시저의 IN 매개변수값 전달 : setXXX
            cstmt.setString(1, customid);
            cstmt.setString(2, buydate);

            //프로시저 OUT 매개변수 1) 타입 설정
            cstmt.registerOutParameter(3, Types.NUMERIC);
            cstmt.executeUpdate();      //프로시저 실행
            // OUT 매개변수 2) 결과값 가져오기 : getXXX
            money = cstmt.getInt(3);
            
        } catch (SQLException e) {
            System.out.println("money_of_day 프로시저 실행 예외 : " + e.getMessage());
        }

        return money;
    }
 }
