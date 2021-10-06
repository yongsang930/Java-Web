package step2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC2 {

	public static void main(String[] args) {
		// Ãß°¡
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("oracle jdbc driver loading ok!");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			Statement stmt = con.createStatement();
			String sql = "insert into member(id, password, name, address) values('spring','aaaa','iu','korea')";
			int result = stmt.executeUpdate(sql);
			System.out.println(result);
			
			stmt.close();
			con.close();
			
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}

//	String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
//	String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";