package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import exception.BookNotFoundException;
import vo.BookVO;

public class BookDAO implements Dao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public void con() {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로드
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); // connection객체생성
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void discon() {
		// TODO Auto-generated method stub
		try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void bookinsert(BookVO b) {
		// TODO Auto-generated method stub

		con();
		// PreparedStatement 변수 값을 편하게 쓰기 위해서(?,?,?,?,?)
		String sql = "insert into book values(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getId());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getAuthor());
			pstmt.setString(4, b.getPublisher());
			pstmt.setInt(5, b.getPrice());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		discon();

	}

	@Override
	public BookVO bookselect(String id) {
		// TODO Auto-generated method stub
		con();
		BookVO b = null;
		// MemberVO table에 있는 id 컬럼과 매서드파라메터 값이 동일한 행 검색
		String sql = "select * from book where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // Query실행
			if (rs.next()) {
				b = new BookVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			} else {
				throw new BookNotFoundException("아이디에 해당하는 책 없음");
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		discon();
		return b;

	}

	@Override
	public void bookupdate(BookVO b) {
		// TODO Auto-generated method stub

		con();
		// PreparedStatement 변수 값을 편하게 쓰기 위해서(?,?,?,?,?)
		String sql = "update book set title=?, author=?,publisher=?, price=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getAuthor());
			pstmt.setString(3, b.getPublisher());
			pstmt.setInt(4, b.getPrice());
			pstmt.setString(5, b.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		discon();

	}

	@Override
	public void bookdelete(String id)  {
		// TODO Auto-generated method stub
		int n = 0;
		con();
		// PreparedStatement 변수 값을 편하게 쓰기 위해서(?,?,?,?,?)
		String sql = "delete book where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			n = pstmt.executeUpdate();
			if (n == 0) {
				throw new BookNotFoundException("아이디에 해당하는 책 없음");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		discon();

	}

	@Override
	public ArrayList bookselectAll() {
		// TODO Auto-generated method stub
		con();
		ArrayList<BookVO> m = new ArrayList<BookVO>();
		// MemberVO table에 있는 id 컬럼과 매서드파라메터 값이 동일한 행 검색
		String sql = "select * from book ";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // Query실행
			while (rs.next()) {
				m.add(new BookVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		discon();
		return m;

	}

}
