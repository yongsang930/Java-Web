package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.MemberVO;

public class MemberDao implements Dao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public void con() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로드
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr"); // 커넥션 객체생성
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void discon() {
		try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void insert(MemberVO m) {
		con();
		String sql = "insert into member values(Member_seq.nextval,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getAddr());
			pstmt.setString(3, m.getTel());
			pstmt.executeUpdate();
			System.out.println("등록 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		discon();
	}

	@Override
	public MemberVO selectMember(String name) {

		con();
		MemberVO m = null;
		String sql = "select * from Member where name = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				m = new MemberVO(rs.getString(2), rs.getString(3), rs.getString(4));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
		return m;
	}

	@Override
	public void update(MemberVO m) {
		con();
		String sql = "update member set addr =?, tel=? where name=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getAddr());
			pstmt.setString(2, m.getTel());
			pstmt.setString(3, m.getName());
			pstmt.executeUpdate();
			System.out.println("--수정 완료--");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		discon();
	}

	@Override
	public void delete(String name) {
		con();
		String sql = "delete member where name =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
	}

	@Override
	public ArrayList printAll() {

		con();
		ArrayList<MemberVO> m = new ArrayList<MemberVO>();
		String sql = "select * from member";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				m.add(new MemberVO(rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
		return m;
	}

}
