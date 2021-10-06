import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBTest {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt= null;  
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url,"hr","hr");
			stmt = conn.createStatement();
			String sql = "select last_name from employees";
			ResultSet rs = stmt.executeQuery(sql); 
			
			int i = 1;
			System.out.println("name");
			while(rs.next()) {
				System.out.println(i+":"+rs.getString(1));
				i++;
			}
			rs.close();
			stmt.close();
			conn.close();
			
		}catch(Exception e) { // 닫혀있다가 열리기 때문에 어떤 예외가 발생할지 모름
			System.out.println(e);
		}
	}
}
