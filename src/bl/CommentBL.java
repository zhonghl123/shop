package bl;


import bo.Comment;
import dao.CommentDAO;

import java.util.List;

public class CommentBL {
    CommentDAO dao= new CommentDAO();
    public void add(Comment comment) {
        dao.add(comment);
    }
    public List<Comment> findByAnime(Integer anime){
        return dao.findByAnime(anime);
    }

    public List<Comment> find(Comment comment) {
        return dao.find(comment);
    }
}
