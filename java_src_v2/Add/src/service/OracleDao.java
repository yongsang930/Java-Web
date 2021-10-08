package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Member;

public class OracleDao implements Dao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public void con() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로드
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr"); // 커넥션 객체생성
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void discon() {
		try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public boolean insert(Member m) {
		con();
		String sql = "insert into addr values(?,?,?)";
		int num = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getTel());
			pstmt.setString(3, m.getAddress());
			num = pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		discon();
		if (num <= 0)
			return false;
		else
			return true;
	}

	@Override
	public ArrayList<Member> print() {
		con();
		ArrayList<Member> list = new ArrayList<Member>();
		ResultSet rs = null;
		String sql = "select * from addr";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Member(rs.getString("name"), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		discon();
		return list;
	}

	@Override
	public Member select(String name) {
		con();
		Member m = null;
		ResultSet rs = null;
		String sql = "select * from addr where name =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				m = new Member(rs.getString("name"), rs.getString(2), rs.getString(3));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
		return m;
	}

	@Override
	public boolean update(Member m) {
		con();
		int num = 0;
		String sql = "update addr set tel = ?, address = ? where name = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getAddress());
			pstmt.setString(2, m.getTel());
			pstmt.setString(3, m.getName());
			num = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
		if (num <= 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean delete(String name) {
		con();
		String sql = "delete addr where name = ?";
		int num = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			num = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
		if (num <= 0)
			return false;
		else
			return true;
	}
}
