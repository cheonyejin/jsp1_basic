package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.vo.MembersVo;
// MembersVo(String code, String name, String email, String phoneNumber, int age)

public class TblMembersDao {

    public static final String URL = "jdbc:oracle:thin:@//192.168.30.21:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // 회원가입
    public void join(MembersVo vo) {

        String sql = "insert into TBL_MEMBERS(code, name, email, phoneNumber, age)" + "values (?,?,?,?,?)";
        try ( // autoclose
                Connection connection = getConnection(); // Connection 객체를 생성
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, vo.getCode());
            pstmt.setString(2, vo.getName());
            pstmt.setString(3, vo.getEmail());
            pstmt.setString(4, vo.getPhoneNumber());
            pstmt.setInt(5, vo.getAge());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("회원가입 실행 예외 발생 : " + e.getMessage());

        }

    }

    // 회원 정보 수정-이메일
    public void modifyEmail(String code, String EMAIL) {
        String sql = "UPDATE TBL_MEMBERS SET EMAIL = ? WHERE code = ?";
        try (
                Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, EMAIL);
            pstmt.setString(2, code);

            pstmt.executeUpdate();
            System.out.println("이메일이 변경되었습니다.");
        } catch (SQLException e) {
            System.out.println("이메일수정 실행 예외 발생: " + e.getMessage());
        }
    }

    // 회원 정보 수정-전화번호
    public void modifyPhone(String code, int phone_number) {
        String sql = "UPDATE TBL_MEMBERS SET phone_number = ? WHERE code = ?";
        try (
                Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setInt(1, phone_number);
            pstmt.setString(2, code);
            System.out.println("전화번호가 변경되었습니다.");

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("전화번호 수정 실행 예외 발생: " + e.getMessage());
        }
    }

    // 회원 탈퇴
    public void delete(String code) {
        String sql = "DELETE FROM TBL_MEMBERS WHERE code = ?";
        try (
                Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, code);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("delete 실행 예외 발생: " + e.getMessage());
        }
    }

}
