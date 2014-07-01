package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionPoolIMP implements ConnectionPool{
    //11/11 完善方法，单例模式，SQL语句完善
    private ArrayList<Connection> pool = new ArrayList<Connection>();
    private final int MAX_SIZE;
    {
        MAX_SIZE = Integer.parseInt(PropertyReader.get("POOL_MAX_SIZE"));
    }
    //private int inUse = 0;
    private static ConnectionPoolIMP conPool = null;

    private ConnectionPoolIMP(){
        //conPool = getConnectionPool();
        System.out.println("单例模式开启");
    }

    public synchronized static ConnectionPoolIMP getConnectionPool(){
        synchronized(ConnectionPoolIMP.class){
            if (conPool == null){
                conPool = new ConnectionPoolIMP();
            }
        }
        return conPool;
    }
    public Connection getConnection() throws SQLException {
        // TODO Auto-generated method stub
        Connection con = null;
		/*if (!pool.isEmpty()){
			con = pool.get(0);
			pool.remove(0);
		}else if (inUse<=MAX_SIZE){
			con = ConnectionProvider.getConncection();
			inUse++;
		}
		 */
        System.out.println(pool.size());
        if (!pool.isEmpty()){
            con = pool.get(0);
            pool.remove(0);
            //if (con == null) con = ConnectionProvider.getConncection();
        }else {
            con = ConnectionProvider.getConncection();
        }
        return con;
    }

    public void releaseConnection(Connection con) {
        // TODO Auto-generated method stub
        if (pool.size()<MAX_SIZE){
            pool.add(con);
        }else{
            try{
                con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void close() {
        // TODO Auto-generated method stub
        for (int i = 0 ;i<pool.size(); i++){
            try{
                pool.get(i).close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        pool.clear();
    }
}
