package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import vo.Event;

public class EventDao {

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

	public void enroll() {
		con();
		Scanner sc = new Scanner(System.in);
		System.out.print("이메일: ");
		String email = sc.next();
		String sql = "insert into input values(A_seq.nextval,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.executeUpdate();
			discon();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList print() {
		con();
		ArrayList<Event> v = new ArrayList<Event>();
		String sql = "select * from input";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				v.add(new Event(rs.getInt(1), rs.getString(2)));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);

		}
		discon();
		return v;
	}

	public Event search(int num) {
		con();
		Event m = null;
		String sql = "select * from input where num=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				m = new Event(rs.getInt(1), rs.getString(2));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
		return m;
	}

	public void updateEvent(Event p) {
		con();
		String sql = "update input set email =? where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getEmali());
			pstmt.setInt(2, p.getNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		discon();

	}

	public void delete(int num) {
		con();
		String sql = "delete input where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		discon();
	}
}
