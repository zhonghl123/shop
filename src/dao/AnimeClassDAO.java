package dao;

import bo.AnimeClassification;
import db.SQLTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnimeClassDAO {
    private SQLTemplate st = new SQLTemplate();;

    public List<AnimeClassification> find(AnimeClassification animeClass) {
        List<AnimeClassification> list = new ArrayList<AnimeClassification>();
        String sql = "select * from p_anime_classification";
        ResultSet rs1;
        if (animeClass.getName() != null && !"".equals(animeClass)) {
            sql += " where name = ?";
            rs1 = st.executeQuery(sql,animeClass.getName());
        }else{
             rs1 = st.executeQuery(sql);
        }
        try {
            while (rs1.next()) {
                AnimeClassification animeClassification = new AnimeClassification();
                animeClassification.setId(rs1.getInt(1));
                animeClassification.setName(rs1.getString(2));
                animeClassification.setCreateTime(rs1.getTimestamp(3));
                list.add(animeClassification);
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return list;
    }

    public void add(AnimeClassification animeClass) {
        String name = animeClass.getName();
        Date createTime = animeClass.getCreateTime();
        String sql = "insert into p_anime_classification(name,create_time) values (?,?)";
        st.executeUpdate(sql, name, createTime);
    }

    public void del(String id) {
        String sql = "delete from p_anime_classification where id=?";
        st.executeUpdate(sql, id);
    }
}