package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Employee;
import vo.Member;
import vo.Professor;
import vo.Student;

public class MemberDAO implements Dao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public void con() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // Class.forName()을 이용해서 드라이버 로드
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); // 연결
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void discon() {
		try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void insert(Member m) {
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
				throw new Exception();

			pstmt.executeUpdate();
			System.out.println("추가 완료");

		} catch (Exception e) {
			System.out.println("추가 오류");
		}
		discon();
	}

	@Override
	public Member selectMember(String id) {

		con();
		Member m = null;
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
				else {
					throw new Exception();
				}
			}
		} catch (Exception e) {
			System.out.println("일치 결과 없음");
		}
		discon();
		return m;
	}

	@Override
	public void update(Member m) {
		con();
		String sql = "update school set name = ?, tel = ?, addr = ?, type = ?, etc = ? where id = ?";

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
			else {
				throw new Exception();
			}
			pstmt.setString(6, m.getId());
			pstmt.executeUpdate();
			System.out.println("수정 완료");
		} catch (Exception e) {
			System.out.println("수정 오류");
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
			System.out.println("삭제 완료");
		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
	}

	@Override
	public ArrayList<Member> printAll(int type) {
		con();
		ResultSet rs = null;
		ArrayList<Member> m = new ArrayList<Member>();
		String sql = "select * from school where type = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			rs = pstmt.executeQuery();
			
			if (type == 1) {
				while (rs.next())
					m.add((new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
							rs.getString(6))));
			} else if (type == 2) {
				while (rs.next())
					m.add((new Professor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getInt(5), rs.getString(6))));
			} else if (type == 3) {
				while (rs.next())
					m.add((new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getInt(5), rs.getString(6))));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		discon();
		return m;
	}
}
