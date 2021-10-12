package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import join.DBConnect;

public class DaoImpl implements Dao {

	private DBConnect db = DBConnect.getInstance();// 스태틱 적인 메모리 생성
	private Connection conn = db.getConnection();
	private PreparedStatement pstmt;

	@Override
	public void insert(Board b) {
		String sql = "insert into board values(seq_board.nextval, ?, ?, ?, sysdate,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getWriter());
			pstmt.setString(2, b.getPwd());
			pstmt.setString(3, b.getTitle());
			pstmt.setString(4, b.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Board select(int num) {
		return null;
	}

	@Override
	public List selectAll() {
		return null;
	}

	@Override
	public void update(Board b) {

	}

	@Override
	public void delete(int num) {
	}
}
