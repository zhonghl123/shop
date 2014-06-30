package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import db.SQLTemplate;
import bo.Goods;

public class GoodsDAO1{
	private SQLTemplate st;

	public ArrayList<Goods> getAllGoods() {
		ArrayList<Goods> goods = new ArrayList<Goods>();
		st = new SQLTemplate();
		//ResultSet rs = st.executeQuery("select *from t_goods");
		String sql = "select  count(*) from t_goods order by limit 2,2 ";
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