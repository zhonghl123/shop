package dao;

import bean.Brand;
import db.SQLTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrandDAO {
    private SQLTemplate st = new SQLTemplate();;

    public List<Brand> find(Brand firm) {
        List<Brand> list = new ArrayList<Brand>();
        String sql = "select * from p_brand";
        ResultSet rs1;
         rs1 = st.executeQuery(sql);
        try {
            while (rs1.next()) {
                Brand bean = new Brand();
                bean.setId(rs1.getInt(1));
                bean.setName(rs1.getString(2));
                bean.setCreateTime(rs1.getTimestamp(3));
                list.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return list;
    }

    public void add(Brand firm) {
        String name = firm.getName();
        Date createTime = firm.getCreateTime();
        String sql = "insert into p_brand(name,create_time) values (?,?)";
        st.executeUpdate(sql, name, createTime);
    }

    public void del(String id) {
        String sql = "delete from p_brand where id=?";
        st.executeUpdate(sql, id);
    }

    public void update(Brand firm) {
        String sql = "update p_brand set name=? where id= ?";
        st.executeUpdate(sql, firm.getName(), firm.getId());
    }
}