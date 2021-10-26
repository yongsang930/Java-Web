package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public void con() {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로드
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); // connection객체생성
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void discon() {
		// TODO Auto-generated method stub
		try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public MemberVO login(String id, String password) throws SQLException {
		MemberVO vo = null;
		con();
		String sql = "select name, address from member where id=? and password=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, password);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			vo = new MemberVO(id, password, rs.getString(1), rs.getString(2));
		}
		discon();
		return vo;
	}
}
