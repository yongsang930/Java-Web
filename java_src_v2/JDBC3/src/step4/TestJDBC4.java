package step4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC4 {
	public static void main(String[] args) {
		//ªË¡¶
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("oracle jdbc driver loading ok!");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			Statement stmt = con.createStatement();
			String sql = "delete from member where name = 'iu'";
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
