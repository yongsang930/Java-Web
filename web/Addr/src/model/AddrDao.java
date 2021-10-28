package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AddrDao {
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public Statement stmt = null;
	public String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	public String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
	ResultSet rs = null;

	private static AddrDao sd = new AddrDao();

	private AddrDao() {
	}

	public static AddrDao getDao() {
		return sd;
	}

	public boolean con() {
		// TODO Auto-generated method stub
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "hr", "hr");
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	public void discon() {
		// TODO Auto-generated method stub
		try {
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void insert(Member p) {
		con();
		String sql = "insert into addr values(addr_seq.nextval,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getTel());
			pstmt.setString(3, p.getAddress());
			pstmt.setInt(4, p.getPostal());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			discon();
		}
	}

	public ArrayList<Member> getAll() {
		con();
		ArrayList<Member> list = new ArrayList<Member>();
		String sql = "select * from addr order by num";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				list.add(new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			discon();
		}
		return list;
	}

	public Member getMember(int num) {
		con();
		String sql = "select * from addr where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			while (rs.next()) {
				Member m = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				return m;
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			discon();
		}
		return null;
	}

	public void edit(Member p) {
		con();
		String sql = "update addr set name=?, tel=?, address=?, postal=? where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getTel());
			pstmt.setString(3, p.getAddress());
			pstmt.setInt(4, p.getPostal());
			pstmt.setInt(5, p.getNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			discon();
		}
	}

	public void delete(int num) {
		con();
		String sql = "delete addr where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			discon();
		}
	}
}
