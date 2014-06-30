package servlet;

import bl.AnimeBL;
import bl.AnimeClassBL;
import bl.CommentBL;
import bo.Anime;
import bo.AnimeClassification;
import common.SystemContext;
import servlet.common.UploadAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class AnimeAction {

	public void action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        AnimeBL animeBL = new AnimeBL();
		String target = null;
		try {
            request.setAttribute("domainList",animeBL.find(new Anime()));
			target = "/anime/animeMain.jsp";
		} catch (Exception e) {
			target = "/error.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

    public void addAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO:上传文件
        Map<String,String> pathMap = UploadAction.getPath(request, response);
        String note = pathMap.get("note");
        String name = pathMap.get("name");
        String pic = pathMap.get("pic");
        String file = pathMap.get("file");
        Integer type = Integer.parseInt(pathMap.get("type"));
        Anime anime  = new Anime();
        anime.setName(name);
        anime.setFile(file);
        anime.setNote(note);
        anime.setType(type);
        anime.setPic(pic);
        anime.setInputer(SystemContext.getUser(request.getSession()).getUsername());
        anime.setCreateTime(new Date());
        AnimeBL animeBL = new AnimeBL();
        String target = null;
        try {
            animeBL.add(anime);
            ServletContext context = request.getSession().getServletContext();
            response.sendRedirect(context.getContextPath()+"/display?method=animeMain");
        } catch (Exception e) {
            request.setAttribute("error",true);
            target = "/anime/animeAdd.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(target);
            rd.forward(request, response);
        }
    }

    public void delAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("id");
        AnimeBL userBL = new AnimeBL();
        String target = null;
        try {
            userBL.del(username);
            ServletContext context = request.getSession().getServletContext();
            response.sendRedirect(context.getContextPath()+"/display?method=animeMain");
        } catch (Exception e) {
            target = "/error.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(target);
            rd.forward(request, response);
        }
    }

    public void detailAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer type =Integer.parseInt(request.getParameter("fenlei"));
        Anime anime= new Anime();
        AnimeBL userBL = new AnimeBL();
        String target = null;
        anime.setType(type);
        try {

            request.setAttribute("animeList",userBL.find(anime));
            target = "anime/animeDetail.jsp";
        } catch (Exception e) {
            target = "/error.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request, response);
    }

    public void addUIAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AnimeClassBL animeClassBL = new AnimeClassBL();
        String target = null;
        try {
            request.setAttribute("animeClassList",animeClassBL.find(new AnimeClassification()));
            target = "anime/animeAdd.jsp";
        } catch (Exception e) {
            target = "/error.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request, response);
    }

    public void animeDetailAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id =Integer.parseInt(request.getParameter("id"));
        Anime anime= new Anime();
        AnimeBL userBL = new AnimeBL();
        String target = null;
        anime.setId(id);
        CommentBL commentBL = new CommentBL();
        try {
            request.setAttribute("anime",userBL.findByPk(id));
            request.setAttribute("commentList",commentBL.findByAnime(id));
            target = "anime/animeShow.jsp";
        } catch (Exception e) {
            target = "/error.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request, response);
    }
}
