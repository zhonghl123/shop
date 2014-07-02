package dao;

import bean.Good;
import db.SQLTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodDAO {
    private SQLTemplate st = new SQLTemplate();;

    public List<Good> find(Good firm) {
        List<Good> list = new ArrayList<Good>();
        String sql = "select *,(select name from p_brand where id=brand) as brandName,(select name from p_firm where id = firm) as firmName from p_good";
        ResultSet rs1;
         rs1 = st.executeQuery(sql);
        try {
            while (rs1.next()) {
                Good bean = new Good();
                bean.setId(rs1.getInt(1));
                bean.setPic(rs1.getString(2));
                bean.setDes(rs1.getString(3));
                bean.setPrice(rs1.getDouble(4));
                bean.setStock(rs1.getInt(5));
                bean.setCreate_time(rs1.getTimestamp(6));
                bean.setName(rs1.getString(7));
                bean.setBrandName(rs1.getString("brandName"));
                bean.setFirmName(rs1.getString("firmName"));
                list.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void add(Good firm) {
        String sql = "insert into p_good(pic,des,price,stock,name,brand,firm) values (?,?,?,?,?,?,?)";
        st.executeUpdate(sql, firm.getPic(),firm.getDes(),firm.getPrice().toString(),firm.getStock(),firm.getName(),firm.getBrand(),firm.getFirm());
    }

    public void del(String id) {
        String sql = "delete from p_good where id=?";
        st.executeUpdate(sql, id);
    }

    public void update(Good firm) {
       /* String sql = "update p_good set pic=? where id= ?";
        st.executeUpdate(sql, firm.getName(), firm.getId());*/
    }

    public Good findByPk(String id) {
        String sql = "select *,(select name from p_brand where id=brand) as brandName,(select name from p_firm where id = firm) as firmName from p_good where id=?";
        ResultSet rs1;
        rs1 = st.executeQuery(sql,id);
        try {
            while (rs1.next()) {
                Good bean = new Good();
                bean.setId(rs1.getInt(1));
                bean.setPic(rs1.getString(2));
                bean.setDes(rs1.getString(3));
                bean.setPrice(rs1.getDouble(4));
                bean.setStock(rs1.getInt(5));
                bean.setCreate_time(rs1.getTimestamp(6));
                bean.setName(rs1.getString(7));
                bean.setBrandName(rs1.getString("brandName"));
                bean.setFirmName(rs1.getString("firmName"));
                return bean;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addBuyInfo(String num, String address, String good_id, String userId) {
        String sql = "insert into p_buy_good(address,good_id,num,user_id) values (?,?,?,?)";
        st.executeUpdate(sql,address,good_id,num,userId);
    }
}