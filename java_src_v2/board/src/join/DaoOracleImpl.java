package join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoOracleImpl implements Dao {

	private DBConnect db = DBConnect.getInstance();
	private Connection conn = db.getConnection();
	private PreparedStatement pstmt;

	@Override
	public int insertMerber(Member m) {
		String sql = "insert into member2 values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			int suc = pstmt.executeUpdate();
			pstmt.close();
			return suc;
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateMember(Member m) {
		String sql = "update member2 set pwd=?, email=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getPwd());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getId());
			int suc = pstmt.executeUpdate();
			pstmt.close();
			return suc;
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean login(String id, String pwd) {
		String sql = "select * from member2 where id = ? and pwd = ?";
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int removerMember(String id) {
		String sql = " delete member2 where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int suc = pstmt.executeUpdate();
			pstmt.close();
			return suc;
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return 0;
	}

	@Override
	public Member memberInfo(String id) {
		return null;
	}
}
