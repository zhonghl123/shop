package bl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import bo.Anime;
import dao.AnimeDAO;
import dao.GoodsDAO;

import bo.Goods;
import bo.InterView;

public class AnimeBL {
    AnimeDAO dao= new AnimeDAO();
    public void add(Anime Anime) {
          AnimeDAO AnimeDAO = new AnimeDAO();
          AnimeDAO.add(Anime);
    }
    public List<Anime> find(Anime anime){
        return dao.find(anime);
    }

    public void del(String id) {
        dao.del(id);
    }

    public Anime findByPk(Integer id) {
           return dao.findByPk(id);
    }
}