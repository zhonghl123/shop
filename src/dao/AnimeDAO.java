package dao;

import bo.Anime;
import db.SQLTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnimeDAO {
    private SQLTemplate st = new SQLTemplate();;

    public List<Anime> find(Anime animeClass) {
        List<Anime> list = new ArrayList<Anime>();
        String sql = "select *,(select name from p_anime_classification where id=type) as animeClassName from p_anime";
        ResultSet rs1;
        if (animeClass.getType() != null) {
            sql += " where type = ?";
            rs1 = st.executeQuery(sql,String.valueOf(animeClass.getType()));
        }else{
             rs1 = st.executeQuery(sql);
        }
        try {
            while (rs1.next()) {
                Anime anime = new Anime();
                anime.setId(rs1.getInt(1));
                anime.setName(rs1.getString(2));
                anime.setCreateTime(rs1.getTimestamp(3));
                anime.setInputer(rs1.getString(4));
                anime.setFile(rs1.getString(5));
                anime.setNote(rs1.getString(6));
                anime.setType(rs1.getInt(7));
                anime.setPic(rs1.getString(8));
                anime.setAnimeClassName(rs1.getString(9));
                list.add(anime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void add(Anime animeClass) {
        try{
        String name = animeClass.getName();
        Date createTime = animeClass.getCreateTime();
        String inputer = animeClass.getInputer();
        String file = animeClass.getFile();
        String note = animeClass.getNote();
        Integer type = animeClass.getType();
        String pic = animeClass.getPic();
        String sql = "insert into p_anime(name,create_time,inputer,file,note,type,pic) values (?,?,?,?,?,?,?)";
        st.executeUpdate(sql, name,createTime,inputer,file,note,type,pic);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void del(String id) {
        String sql = "delete from p_anime where id=?";
        st.executeUpdate(sql, id);
    }

    public Anime findByPk(Integer id) {
        Anime anime = new Anime();
        ResultSet rs1 = st.executeQuery("select * from p_anime where id=?",String.valueOf(id));
        try {
            while (rs1.next()) {
                anime.setId(rs1.getInt(1));
                anime.setName(rs1.getString(2));
                anime.setCreateTime(rs1.getTimestamp(3));
                anime.setInputer(rs1.getString(4));
                anime.setFile(rs1.getString(5));
                anime.setNote(rs1.getString(6));
                anime.setType(rs1.getInt(7));
                anime.setPic(rs1.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return anime;
    }
}