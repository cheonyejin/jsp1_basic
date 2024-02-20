package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TblMenuDao {
    // DB 연결하기
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL = "jdbc:oracle:thin:@//192.168.30.21:1521/xe"; // 192.168.30.21
    public static final String USERNAME = "c##idev";
    public static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    //// getPriceTable() : 상품테이블에서 pcode와 price를 조회하여 Map에 저장하기
    public Map<String, Integer> getPriceTable() {
        Map<String, Integer> map = new HashMap<>();
        String sql = "SELECT mcode, mprice from TBL_MENU";

        try (
                Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) { // 조회 결과는 n행 가능성 예측
                map.put(rs.getString(1), // key
                        rs.getInt(2)); // value
            }
        } catch (SQLException e) {
            System.out.println("getPriceTable 예외 발생 " + e.getMessage());
        }
        return map;
    }

}
