package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import vo.BookVO;

public class BookDAO {

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

	public void bookinsert(BookVO bvo) {
		con();
		String sql = "insert into book values(book_seq.nextval,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getId());
			pstmt.setString(2, bvo.getTitle());
			pstmt.setString(3, bvo.getPublisher());
			pstmt.setInt(4, bvo.getPrice());
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
	}

	public BookVO booksearch(String id) {
		con();
		BookVO bb = null;
		String sql = "select * from book where id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bb = new BookVO(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
		return bb;
	}

	public void bookupdate(BookVO bvo) {
		con();
		String sql = "update book set title =?, publisher = ?, price =? where id = ?";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getTitle());
			pstmt.setString(2, bvo.getPublisher());
			pstmt.setInt(3, bvo.getPrice());
			pstmt.setString(4, bvo.getId());
			pstmt.executeUpdate();
			System.out.println("수정완료");
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();

	}

	public void bookdelete() {

	}

	public ArrayList bookselectAll() {
		return null;
	}
}
