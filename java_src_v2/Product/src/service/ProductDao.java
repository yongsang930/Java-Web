package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Product;

public class ProductDao {

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

	public void insert(Product p) {
		con();
		String sql = "insert into product values(?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getP_id());
			pstmt.setString(2, p.getP_name());
			pstmt.setInt(3, p.getNum());
			pstmt.setString(4, p.getCo());
			pstmt.setInt(5, p.getPrice());
			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		discon();
	}

	public ArrayList printAll() {
		con();
		ArrayList<Product> m = new ArrayList<Product>();
		String sql = "select * from product";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				m.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
		return m;
	}

	public Product seadchProduct(int p_id) {
		con();

		Product m = null;
		String sql = "select * from product where p_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				m = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
		return m;
	}

	public void updateProduct(Product p) {
		con();
		String sql = "update product set name=?,num=?,co=?,price=? where p_id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getP_name());
			pstmt.setInt(2, p.getNum());
			pstmt.setString(3, p.getCo());
			pstmt.setInt(4, p.getPrice());
			pstmt.setInt(5, p.getP_id());
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
	}

	public void delete(int p_id) {
		con();
		String sql = "delete product where p_id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_id);
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		discon();

	}
}
