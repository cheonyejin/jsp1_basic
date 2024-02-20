package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.vo.ProductVo;

public class TblProductDao {

    // DB 연결하기
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL = "jdbc:oracle:thin:@//192.168.30.21:1521/xe"; // 192.168.30.21
    public static final String USERNAME = "c##idev";
    public static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // 카테고리로 상품 조회하기 selectByCategory
    public List<ProductVo> selectByCategory(String category) {
        List<ProductVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_PRODUCT \r\n" +
                "WHERE  CATEGORY = ? \r\n" +
                "ORDER BY PNAME ";

        try (
                Connection connection = getConnection(); // connection 객체 생성
                PreparedStatement pstmt = connection.prepareStatement(sql)) { // pstmt객체를 만들고 ,connection객체를
                                                                              // PreparedStatement메소드에 쓴값을 저장한다

            pstmt.setString(1, category); // setString() : PreparedStatement인터페이스의 메서드
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(new ProductVo(rs.getString(1), // getString() : ResultSet인터페이스의 메서드
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)));
            }
        } catch (SQLException e) {
            System.out.println("selectBycategory 예외 발생" + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    // 상품이름으로 조회하기 (유사검색) selectByPname
    public List<ProductVo> selectByPname(String pname) {
        List<ProductVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_PRODUCT tp\r\n" +
                "WHERE pname LIKE '%'|| ? || '%'\r\n" +
                "ORDER BY CATEGORY";

        try (
                Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, pname);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(new ProductVo(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)));
            }

        } catch (SQLException e) {
            System.out.println("selectBycategory 예외 발생" + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    // 상품코드로 조회하기
    public List<ProductVo> selectByPcode(String pcode) {
        List<ProductVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_PRODUCT \r\n" +
                "WHERE  PCODE = ? \r\n" +
                "ORDER BY PNAME ";

        try (
                Connection connection = getConnection(); // connection 객체 생성
                PreparedStatement pstmt = connection.prepareStatement(sql)) { // pstmt객체를 만들고 ,connection객체를
                                                                              // PreparedStatement메소드에 쓴값을 저장한다

            pstmt.setString(1, pcode); // setString() : PreparedStatement인터페이스의 메서드
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(new ProductVo(rs.getString(1), // getString() : ResultSet인터페이스의 메서드
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)));
            }
        } catch (SQLException e) {
            System.out.println("selectBycategory 예외 발생" + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    //// getPriceTable() : 상품테이블에서 pcode와 price를 조회하여 Map에 저장하기
    public Map<String, Integer> getPriceTable() {
        Map<String, Integer> map = new HashMap<>();
        String sql = "SELECT pcode, price from tbl_product";

        try (
                Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) { // 조회 결과는 n행 가능성 예측
                map.put(rs.getString(1), // key
                        rs.getInt(2)); // value
            }
        } catch (SQLException e) {
            System.out.println("getProceTable 예외 발생 " + e.getMessage());
        }
        return map;
    }

}
