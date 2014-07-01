package dao;

import bean.Firm;
import db.SQLTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FirmDAO {
    private SQLTemplate st = new SQLTemplate();;

    public List<Firm> find(Firm firm) {
        List<Firm> list = new ArrayList<Firm>();
        String sql = "select * from p_firm";
        ResultSet rs1;
        if (firm.getName() != null && !"".equals(firm)) {
            sql += " where name = ?";
            rs1 = st.executeQuery(sql, firm.getName());
        }else{
             rs1 = st.executeQuery(sql);
        }
        try {
            while (rs1.next()) {
                Firm bean = new Firm();
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

    public void add(Firm firm) {
        String name = firm.getName();
        Date createTime = firm.getCreateTime();
        String sql = "insert into p_firm(name,create_time) values (?,?)";
        st.executeUpdate(sql, name, createTime);
    }

    public void del(String id) {
        String sql = "delete from p_firm where id=?";
        st.executeUpdate(sql, id);
    }

    public void update(Firm firm) {
        String sql = "update p_firm set name=? where id= ?";
        st.executeUpdate(sql, firm.getName(), firm.getId());
    }
}