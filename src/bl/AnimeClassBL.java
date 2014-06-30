package bl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import bo.AnimeClassification;
import dao.AnimeClassDAO;
import dao.GoodsDAO;

import bo.Goods;
import bo.InterView;

public class AnimeClassBL {
    AnimeClassDAO dao= new AnimeClassDAO();
	public ArrayList<Goods> getFavoritGoods() throws ParseException{
		GoodsDAO goodsDao = new GoodsDAO();
		return goodsDao.getAllGoods();
	}
	
	public ArrayList<Goods> delete(String id) throws ParseException{
		GoodsDAO goodsDao  = new GoodsDAO();
		goodsDao.delete(id);
		return goodsDao.getAllGoods();
	}
	
	public ArrayList<Goods> change(Goods goods) throws ParseException{
		GoodsDAO goodsDao = new GoodsDAO();
		goodsDao.update(goods);
		return goodsDao.getAllGoods();
	}

	public void insert(Goods goods) {
		GoodsDAO goodsDao = new GoodsDAO();
		goodsDao.insert(goods);
	}

	public void addInterview(InterView iv) {
		GoodsDAO goodsDao = new GoodsDAO();
		goodsDao.insertInterview(iv);
		
	}

    public boolean add(AnimeClassification animeClass) {
          AnimeClassDAO animeClassDAO = new AnimeClassDAO();
          List<AnimeClassification> list = animeClassDAO.find(animeClass);
        if(list!=null&&!list.isEmpty()){
             return false;
        }else{
            animeClassDAO.add(animeClass);
            return false;
        }
    }
    public List<AnimeClassification> find(AnimeClassification animeClass){
        return dao.find(animeClass);
    }

    public void del(String id) {
        AnimeClassDAO animeClassDAO = new AnimeClassDAO();
        animeClassDAO.del(id);
    }
}