package bl;


import bo.Reply;
import dao.ReplyDAO;

import java.util.List;

public class ReplyBL {
    ReplyDAO dao= new ReplyDAO();
    public void add(Reply comment) {
        dao.add(comment);
    }
    public List<Reply> find(Reply comment) {
        return dao.find(comment);
    }
}
