package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.vo.BuyMenuVo;
import project.vo.MemberBuyVo;

public class TblBuyMenuDao {

    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL = "jdbc:oracle:thin:@//192.168.30.21:1521/xe"; // 192.168.30.21
    public static final String USERNAME = "c##idev";
    public static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // 장바구니 한번에 insert 실행
    public int allAtOnes(List<BuyMenuVo> code) {
        String sql = "insert into tbl_buy_menu values(burger_seq.nextval,?,?,?,sysdate)";
        Connection connection = null;
        PreparedStatement pstmt = null;
        int count = 0;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            for (BuyMenuVo vo : code) {

                pstmt.setString(1, vo.getCustomerId());
                pstmt.setString(2, vo.getMenuId());
                pstmt.setInt(3, vo.getMenuQuantity());
                pstmt.addBatch();
                count++;
            }
            pstmt.executeBatch();
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
            }
            count = -1;
            System.out.println("구매불가능한 상품이 있습니다.");
            System.out.println("장바구니 구매 실행 예외 발생" + e.getMessage());
        } finally {
            try {
                pstmt.close();
                connection.close();
            } catch (Exception e) {
            }
        }
        return count;

    }

    // mypage 기능
    // mypage 기능
    public List<MemberBuyVo> selectMemberBuy(String customer_id) {
        List<MemberBuyVo> list = new ArrayList<>();
        String sql = "SELECT BUY_INDEX ,CUSTOMER_ID ,tm.MNAME ,tm.MCODE ,TBM.MENU_QUANTITY ,tm.mprice,TBM.BUY_DATE" +
                " FROM TBL_BUY_MENU tbm" +
                " JOIN TBL_MENU tm" +
                " ON tbm.MENU_ID =tm.MCODE" +
                " WHERE TBM.CUSTOMER_ID =?";

        try (
                Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, customer_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new MemberBuyVo(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getTimestamp(7)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

}// selectCustomerBuyList
