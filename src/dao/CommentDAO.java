package dao;


import bo.Comment;
import db.SQLTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentDAO {
    private SQLTemplate st = new SQLTemplate();
    ;

    public List<Comment> findByAnime(Integer id) {
        List<Comment> list = new ArrayList<Comment>();
        String sql = "select * from p_comment where anime_id=?";
        ResultSet rs1;
        rs1 = st.executeQuery(sql, String.valueOf(id));
        try {
            while (rs1.next()) {
                Comment anime = new Comment();
                anime.setId(rs1.getInt(1));
                anime.setAnimeId(rs1.getInt(2));
                anime.setInputer(rs1.getString(3));
                anime.setCreateTime(rs1.getTimestamp(4));
                anime.setContent(rs1.getString(5));
                list.add(anime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void add(Comment animeClass) {
        try {
            Integer animeId = animeClass.getAnimeId();
            Date createTime = animeClass.getCreateTime();
            String inputer = animeClass.getInputer();
            String content = animeClass.getContent();
            String sql = "insert into p_comment(anime_id,inputer,create_time,content) values (?,?,?,?)";
            st.executeUpdate(sql, animeId, inputer, createTime, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Comment> find(Comment comment) {
        List<Comment> list = new ArrayList<Comment>();
        String sql = "select * from p_comment";
        ResultSet rs1;
        rs1 = st.executeQuery(sql);
        try {
            while (rs1.next()) {
                Comment anime = new Comment();
                anime.setId(rs1.getInt(1));
                anime.setAnimeId(rs1.getInt(2));
                anime.setInputer(rs1.getString(3));
                anime.setCreateTime(rs1.getTimestamp(4));
                anime.setContent(rs1.getString(5));
                list.add(anime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
