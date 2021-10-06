package prod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Product {
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public String jdbc_driver;
	public String jdbc_url;
	public ResultSet rs = null;

	public Product() {
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

	public void ProductInsert() {
		con();
		Scanner sc = new Scanner(System.in);
		System.out.print("제품번호: ");
		int p_id = sc.nextInt();

		System.out.print("제품이름: ");
		String name = sc.next();

		System.out.print("제품수량: ");
		int num = sc.nextInt();

		System.out.print("제조사: ");
		String co = sc.next();

		System.out.print("제품가격: ");
		int price = sc.nextInt();

		String sql = "insert into member values(?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_id);
			pstmt.setString(2, name);
			pstmt.setInt(3, num);
			pstmt.setString(4, co);
			pstmt.setInt(5, price);
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void productPrint() {
		con();
		String sql = "select * from product";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("제품번호: " + rs.getInt(1));
				System.out.println("제품명: " + rs.getString(2));
				System.out.println("수량: " + rs.getInt(3));
				System.out.println("제조사: " + rs.getString(4));
				System.out.println("가격: " + rs.getInt(5));
				System.out.println("----------------------------");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean ProductSearch(int p_id) {
		con();
		String sql = "select * from product where p_id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (p_id == rs.getInt(1)) {
					System.out.println("제품번호: " + rs.getInt(1));
					System.out.println("제품명: " + rs.getString(2));
					System.out.println("수량: " + rs.getInt(3));
					System.out.println("제조사: " + rs.getString(4));
					System.out.println("가격: " + rs.getInt(5));
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
		return false;
	}

	public void order() {
		Scanner sc = new Scanner(System.in);
		System.out.println("상호: ");
		String cus = sc.next();

		System.out.println("제품번호: ");
		int p_id = sc.nextInt();

		System.out.println("주문수량: ");
		int num = sc.nextInt();

		boolean f = ProductSearch(p_id);
		if (!f) {
			System.out.println("제품코드오류");
			return;
		}
		con();
		try {
			String sql1 = "select num from poduct where p_id=?";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, p_id);
			
			rs = pstmt.executeQuery();
			rs.next();
			int n = rs.getInt(1);
			
			if(n > num) {
				System.out.println("수량이 크~네");
				return;
			}else {
				n -= num;
				NumUpdate(p_id, n);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
		
		con();
		try {
			String sql = "insert into order1 values(?,sysdate,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cus);
			pstmt.setInt(2, p_id);
			pstmt.setInt(3, num);
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		discon();
	}

	public void NumUpdate(int p_id, int num) {

		con();
		try {
			String sql = "update product set num = ? where p_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, p_id);
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
	}

	public void print_ord() {
		con();
		
		String sql = "select * from order1";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print("상호: "+rs.getString(1));
				System.out.print("주문날짜: "+rs.getString(2));
				System.out.print("제품번호: "+rs.getInt(3));
				System.out.print("주문수량: "+rs.getInt(4));
				System.out.println("----------------------------");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		discon();
	}
}
