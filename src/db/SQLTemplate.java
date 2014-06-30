package db;


import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

public class SQLTemplate {
	private Statement stmt = null;
	private Connection con = null;
	private ResultSet rs = null;
	private ConnectionPoolIMP conPool = ConnectionPoolIMP.getConnectionPool();
	private PreparedStatement pstmt;
	public SQLTemplate() {
		try {
			con = conPool.getConnection();
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ResultSet executeQuery(String sql,String ...args) {
		
		/*try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;*/
		try{
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			for (int i = 0; i < args.length; i++){
				pstmt.setString(i+1,args[i]);
			}
			rs = pstmt.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}

	public void executeUpdate(String sql,Object ...args) {
		Connection con = null;
        Object[] newArray=args;
		try {
			con=ConnectionPoolIMP.getConnectionPool().getConnection();
			PreparedStatement pstmt =   (PreparedStatement) con.prepareStatement(sql);
         for(int i=0;i<newArray.length;i++){
             if(newArray[i] instanceof Date){
                 pstmt.setTimestamp(i + 1, new Timestamp(((Date)newArray[i]).getTime()));
             } else if(newArray[i] instanceof Integer){
                 pstmt.setInt(i + 1,(Integer)newArray[i]);
             }else{
                 pstmt.setString(i+1, (String)newArray[i]);
             }

         }
         	System.out.println(pstmt);
			pstmt.executeUpdate();
			//stmt.executeUpdate(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			conPool.releaseConnection(con);
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
