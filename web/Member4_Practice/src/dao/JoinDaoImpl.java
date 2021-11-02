package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.catalina.startup.RealmRuleSet;

import conn.DBConnect;
import model.Member;

public class JoinDaoImpl implements JoinDao {
	private DBConnect db;

	public JoinDaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public boolean insert(Member m) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member values(?,?,?,?)";
		try {
			if (select(m.getId(), m.getPwd()) == null) {
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, m.getId());
				pstmt.setString(2, m.getPwd());
				pstmt.setString(3, m.getName());
				pstmt.setString(4, m.getEmail());
				pstmt.executeUpdate();
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public Member select(String id, String pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
		String sql = "select * from member where id=? and pwd=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				m = new Member(id, pwd, rs.getString(2), rs.getString(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return m;
	}

	@Override
	public void update(Member m) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update member set pwd=?, name=?, email=? where id=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getPwd());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void delete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete member where id=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
