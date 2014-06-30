package db;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool {
	public Connection getConnection() throws SQLException;
	
	public void releaseConnection(Connection con) ;
	
	public void close();
}
