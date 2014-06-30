package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.ResultSet;

public class ConnectionProvider {
	public static String URL;
	private static String USER_NAME;
	private static String PASSWORD;
	private static String DRIVER;
	private ResultSet rs = null;
	private Statement stmt = null;
	static {
		/*URL = "jdbc:mysql://localhost:3306/website";
		USER_NAME ="root" ;
		PASSWORD = "root";
		DRIVER = "com.mysql.jdbc.Driver";*/
		USER_NAME = PropertyReader.get("DB_USER");
		URL = PropertyReader.get("DB_URL");
		PASSWORD = PropertyReader.get("DB_PASSWORD");
		DRIVER = PropertyReader.get("JDBC_DRIVER");
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConncection() throws SQLException{
		Connection con = null;
		con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		return con;
	}
	
	
}
