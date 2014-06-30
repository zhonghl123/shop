package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import bo.Goods;
import bo.InterView;
import db.SQLTemplate;

public class GoodsDAO {
	private SQLTemplate st;

	public ArrayList<Goods> getAllGoods() {
		ArrayList<Goods> goods = new ArrayList<Goods>();
		st = new SQLTemplate();
		String sql = "select * from t_goods";
		ResultSet rs = st.executeQuery(sql);
		try {
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				Date date = rs.getDate(4);
				System.out.println(name + "  " + price);
				Goods theGoods = new Goods(id, name, price, date);
				goods.add(theGoods);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			st.close();

		}
		return goods;
	}

	public void delete(String id) {
		st = new SQLTemplate();
		/*String sql = "delete  from t_goods where id=" + "'" + id + "'";
		st.executeUpdate(sql);
		st.close();*/
		String sql = "delete from t_goods where id = ?";
		st.executeUpdate(sql, id);
		st.close();
	}

	public Goods findGoods(String id) {
		/*st = new SQLTemplate();
		ResultSet rs = st.executeQuery("select * from t_goods where id=" + id);
		Goods goods = null;
		try {
			while (rs.next()) {
				goods = new Goods(rs.getInt(1) + "", rs.getString(2),
						rs.getInt(3), rs.getDate(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			st.close();
		}
		return goods;*/
		st = new SQLTemplate();
		String sql = "select * from t_goods where id = ?";
		ResultSet rs = st.executeQuery(sql, id);
		Goods goods = null;
		try {
			while (rs.next()) {
				goods = new Goods(rs.getInt(1) + "", rs.getString(2),
						rs.getInt(3), rs.getDate(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			st.close();
		}
		return goods;
	}

	public void update(Goods goods) {
		st = new SQLTemplate();
		String sql = "update t_goods set name=?,price=? where id= ?";
		//String sql2 = "UPDATE t_goods SET price= ? where id=?";
		/*Date date = goods.getDate();
		
		String newDate=getNewDate(date);
        System.out.println();*/
		st.executeUpdate(sql,goods.getName(),goods.getPrice()+"",goods.getId());
		/*st.update(sql);
		st.update(sql2);
		st.close();*/
	}

	public void insert(Goods goods) {
		st = new SQLTemplate();
		
		
		/*  String sql = "insert into goods (name,price,date)  values (" + "'" +
		  goods.getName() + "'" + "," + goods.getPrice() + ",'2011-11-18')";*/
		 
		String sql = "insert into t_goods(name,price,date) values (?,?,?)";

		Date date = goods.getDate();
		/*try {
			Connection con=ConnectionPoolIMP.getConnectionPool().getConnection();
			PreparedStatement pstmt =   (PreparedStatement) con.prepareStatement(sql);

			pstmt.setString(1, goods.getName());
			pstmt.setDouble(2, goods.getPrice());
			Date date = goods.getDate();
			
			pstmt.setString(3, getNewDate(date));*/
		//pstmt.addBatch();

			//pstmt.executeUpdate();
			String newDate=getNewDate(date);
             System.out.println(sql);
			st.executeUpdate(sql,goods.getName(),goods.getPrice()+"",newDate);
			st.close();

	/*} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
   private String getNewDate(Date date){
	   SimpleDateFormat f2 = new SimpleDateFormat("yyyy-MM-dd");
		String newDate = f2.format(date);
		return newDate;
   }

	public void insertInterview(InterView iv) {
		String sql = "insert into t_interview(interview,uploader) values (?,?)";
		
	}
	public static void main(String[] args) {
		GoodsDAO g = new GoodsDAO();
		Goods gs = new Goods("5","wei4", 99, new Date());
		//g.update(gs);
		//g.delete("5");
		// g.update(gs);
		// g.getAllGoods();
		//System.out.println(g.findGoods("3").getName());
		//g.findGoods("3");
		/*for (int i = 0; i<g.getAllGoods().size(); i++){
			System.out.println(g.getAllGoods().get(i).getName());
		}*/
	}

}