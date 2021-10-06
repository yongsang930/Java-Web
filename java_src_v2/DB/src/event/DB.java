package event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DB {

	public Connection con = null; // DB와 연결
	public PreparedStatement pstmt = null;
	public String jdbc_driver;
	public String jdbc_url;
	public ResultSet rs = null;

	public DB() {
		jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	}

	public void con() {
		try {
			Class.forName(jdbc_driver);
			con = DriverManager.getConnection(jdbc_url, "hr", "hr");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void discon() {
		try {
			if (rs != null) {
				rs.close();
			}
			pstmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void enroll() {
		con();
		Scanner sc = new Scanner(System.in);
		System.out.print("이메일: ");
		String email = sc.next();
		String sql = "insert into input values(A_seq.nextval, ?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.executeUpdate();
			discon();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void print() {
		con();
		String sql = "select * from input";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 값을 가져온다
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
			discon();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean search(int num) {
		con();
		String sql = "select * from input where num = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(2));
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
		return false;
	}

	public void update(int j, String email) {
		con();
		Scanner sc = new Scanner(System.in);
		String sql = "update input set email = ? where num = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setInt(2, j);
			pstmt.executeUpdate();
			discon();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void delete(int j) {
		con();
		String sql = "delete from input where num = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, j);
			pstmt.executeUpdate();
			discon();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
