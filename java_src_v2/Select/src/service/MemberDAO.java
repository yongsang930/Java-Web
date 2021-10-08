package service;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Employee;
import vo.Professor;
import vo.Student;
import vo.member;

public class MemberDAO implements Dao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public void con() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // ����̹� �ε�
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void discon() { // close�޼��� insert,update�� ����ϸ� ȣ��
		try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void insert(member m) {
		con();
		String sql = "insert into school values(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getTel());
			pstmt.setString(4, m.getAddr());
			pstmt.setInt(5, m.getType());
			if (m instanceof Professor)
				pstmt.setString(6, ((Professor) m).getDept());
			else if (m instanceof Employee)
				pstmt.setString(6, ((Employee) m).getJob());
			else if (m instanceof Student)
				pstmt.setString(6, ((Student) m).getSchool());
			else
				System.out.println("일치하는 타입이 없습니다.");
			pstmt.executeUpdate();
			System.out.println("등록 완료");
		} catch (SQLException se) {
			se.printStackTrace();
		}
		discon();
	}

	@Override
	public member selectMember(String id) {
		con();
		member m = null;
		String sql = "select * from school where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getInt("type") == 1)
					m = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
							rs.getString(6));
				else if (rs.getInt("type") == 2)
					m = new Professor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
							rs.getString(6));
				else if (rs.getInt("type") == 3)
					m = new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
							rs.getString(6));
			} else {
				System.out.println("일치하는 검색 결과가 없음");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
		return m;
	}

	@Override
	public void update(member m) {
		con();
		String sql = "update school set name = ?, tel = ?, addr = ?, type = ?, etc=? where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getTel());
			pstmt.setString(3, m.getAddr());
			pstmt.setInt(4, m.getType());
			if (m instanceof Professor)
				pstmt.setString(5, ((Professor) m).getDept());
			else if (m instanceof Employee)
				pstmt.setString(5, ((Employee) m).getJob());
			else if (m instanceof Student)
				pstmt.setString(5, ((Student) m).getSchool());
			else
				System.out.println("일치하는 타입이 없습니다.");
			pstmt.setString(6, m.getId());
			pstmt.executeUpdate();
			System.out.println("수정 완료");
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();

	}

	@Override
	public void delete(String id) {

		con();
		String sql = "delete school where id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			System.out.println();
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
	}

	@Override
	public ArrayList selectAll(int type) {
		con();
		ResultSet rs = null;
		ArrayList<member> m = new ArrayList<member>();
		String sql = "select * from school where type = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			rs = pstmt.executeQuery();

			if (type == 1) {
				while (rs.next())
					m.add((new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),rs.getString(6))));
			}
			if (type == 2) {
				while (rs.next())
					m.add((new Professor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),rs.getString(6))));
			}
			if (type == 3) {
				while (rs.next())
					m.add((new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),rs.getString(6))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		discon();
		return m;
	}

}
