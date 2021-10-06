package book;

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

	public void bookInsert() {
		con();
		Scanner sc = new Scanner(System.in);
		System.out.print("저자 입력: ");
		String author = sc.nextLine();

		System.out.print("책 제목 입력: ");
		String title = sc.nextLine();

		System.out.print("출판사 입력: ");
		String publisher = sc.nextLine();

		System.out.print("가격 입력: ");
		int price = sc.nextInt();

		String sql = "insert into book values(book_seq.nextval,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, author);
			pstmt.setString(2, title);
			pstmt.setString(3, publisher);
			pstmt.setInt(4, price);
			pstmt.executeUpdate();
			discon();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void bookPrint() {
		con();
		String sql = "select * from book";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("1.저자: " + rs.getString(2));
				System.out.println("2.제목: " + rs.getString(3));
				System.out.println("3.출판사: " + rs.getString(4));
				System.out.println("4.가격: " + rs.getInt(5));
				System.out.println("---------------------");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
	}

	public boolean bookSearch(String title) {
		con();
		String sql = "select * from book where title = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (title.equals(rs.getString(3))) {
					System.out.println("---------------------");
					System.out.println("1.저자: " + rs.getString(2));
					System.out.println("2.제목: " + rs.getString(3));
					System.out.println("3.출판사: " + rs.getString(4));
					System.out.println("4.가격: " + rs.getInt(5));
					System.out.println("---------------------");
					return true;
				}
			}
			System.out.println("검색결과: 일치하는 검색결과 없음");
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
		return false;
	}

	public boolean bookDiscount(String title) {
		con();
		String sql = "select num,id,title,publisher,(price*0.9)as price from book where title = ? order by num";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (title.equals(rs.getString(3))) {
					System.out.println("---------------------");
					System.out.println("1.저자: " + rs.getString(2));
					System.out.println("2.제목: " + rs.getString(3));
					System.out.println("3.출판사: " + rs.getString(4));
					System.out.println("4.가격: " + rs.getInt(5));
					System.out.println("---------------------");
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
		return false;
	}

	public void bookBuy(String title) {
		con();
		String sql1 = "select * from book";
		String sql = "delete book where title = ?";

		try {
			if(bookSearch(title)) {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.executeUpdate();
			System.out.println("구매 완료");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
	}

}
