package dao;


import bo.Reply;
import db.SQLTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReplyDAO {
    private SQLTemplate st = new SQLTemplate();
    ;
    public void add(Reply animeClass) {
        try {
            Integer animeId = animeClass.getAnimeId();
            Integer commentId = animeClass.getCommentId();
            Date createTime = animeClass.getCreateTime();
            String inputer = animeClass.getInputer();
            String content = animeClass.getContent();
            String sql = "insert into p_reply(comment_id,anime_id,create_time,inputer,content) values (?,?,?,?,?)";
            st.executeUpdate(sql,commentId,animeId, createTime,inputer, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Reply> find(Reply comment) {
        List<Reply> list = new ArrayList<Reply>();
        String sql = "select * from p_reply";
        ResultSet rs1;
        rs1 = st.executeQuery(sql);
        try {
            while (rs1.next()) {
                Reply anime = new Reply();
                anime.setId(rs1.getInt(1));
                anime.setCommentId(rs1.getInt(2));
                anime.setAnimeId(rs1.getInt(3));
                anime.setCreateTime(rs1.getTimestamp(4));
                anime.setInputer(rs1.getString(5));
                anime.setContent(rs1.getString(6));
                list.add(anime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
