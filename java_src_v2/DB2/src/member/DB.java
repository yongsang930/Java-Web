package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DB {
	public Connection conn = null;
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
			conn = DriverManager.getConnection(jdbc_url, "hr", "hr");
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
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void MemberInsert() {
		con();
		Scanner sc = new Scanner(System.in);
		System.out.print("이름: ");
		String name = sc.next();

		System.out.print("주소: ");
		String addr = sc.next();

		System.out.print("전화번호: ");
		String tel = sc.next();

		String sql = "insert into member values(member_seq.nextval,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.setString(3, tel);
			pstmt.executeUpdate();
			discon();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void MemberPrint() {
		con();
		String sql = "select * from Member order by num";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("번호: " + rs.getInt(1));
				System.out.println("이름: " + rs.getString(2));
				System.out.println("주소: " + rs.getString(3));
				System.out.println("전화번호: " + rs.getString(4));
				System.out.println("------------------------");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
	}

	public boolean search(String name) {
		con();
		String sql = "select * from member where name = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("주소: " + rs.getString(3));
				System.out.println("전화번호: " + rs.getString(4));
				return true;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
		return false;
	}

	public void update() {
		con();
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 사람의 이름: ");
		String j = sc.next();

		System.out.print("주소: ");
		String addr = sc.next();

		System.out.print("전화번호: ");
		String tel = sc.next();

		String sql = "update Member set add=?, tel=? where name=?;";

		try {
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void delete() {
		con();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 사람의 이름을 입력: ");
		String j = sc.next();
		String sql = "delete member where name = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			discon();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
