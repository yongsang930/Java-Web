package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Customer;

public class CusDAO implements Dao2{
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
	public void Cusinsert(Customer b) {
		// TODO Auto-generated method stub
		con();
		// PreparedStatement 변수 값을 편하게 쓰기 위해서(?,?,?,?,?)
		String sql = "insert into Customer values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getName());
			pstmt.setString(2, b.getAddr());
			pstmt.setString(3, b.getTel());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		discon();
		
	
	
	
	}

	@Override
	public Customer Cusselect(String name) {
		// TODO Auto-generated method stub
		con();
		Customer b = null;
		// MemberVO table에 있는 id 컬럼과 매서드파라메터 값이 동일한 행 검색
	String sql = "select * from Customer where name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery(); // Query실행
			if (rs.next()) {
	b = new Customer(rs.getString(1), rs.getString(2),
						rs.getString(3));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		discon();
		return b;
		
	
	
	
	}

	@Override
	public void Cusupdate(Customer b) {
		// TODO Auto-generated method stub
		con();
		// PreparedStatement 변수 값을 편하게 쓰기 위해서(?,?,?,?,?)
String 
sql = "update Customer set addr=?, tel=? where name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, b.getAddr());
			pstmt.setString(2, b.getTel());
			pstmt.setString(3, b.getName());		
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		discon();
		
	
	
	
	}

	@Override
	public void Cusdelete(String name) {
		// TODO Auto-generated method stub
		con();
		// PreparedStatement 변수 값을 편하게 쓰기 위해서(?,?,?,?,?)
		String sql = "delete Customer where name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		discon();
	
	
	
	}

	@Override
	public ArrayList CusselectAll() {
		// TODO Auto-generated method stub
		con();
	ArrayList<Customer> m = new ArrayList<Customer>();
		// MemberVO table에 있는 id 컬럼과 매서드파라메터 값이 동일한 행 검색
		String sql = "select * from Customer ";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // Query실행
			while (rs.next()) {
m.add(new Customer(rs.getString(1), rs.getString(2),
						rs.getString(3)));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		discon();
		return m;
	
	
	
	
	}

	
}