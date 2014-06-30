package db;

import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	private static Properties ps;
	
	static{
		String name = "/resource/db.conf";
		ps = new Properties();
		try{
			InputStream in = PropertyReader.class.getResourceAsStream(name);
			ps.load(in);
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static String get(String key){
		return ps.getProperty(key);
	}
	public static void main(String args[]){
		System.out.println(PropertyReader.get("JDBC_DRIVER"));
	}
}
