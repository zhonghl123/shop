package servlet;

import bl.AnimeClassBL;
import bl.UserBL;
import bo.AnimeClassification;
import bo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class AnimeClassAction {

	public void action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		AnimeClassification  domain = new AnimeClassification();
        domain.setName(name);
        AnimeClassBL animeCLassBL = new AnimeClassBL();
		String target = null;
		try {
            request.setAttribute("domainList",animeCLassBL.find(domain));
			target = "/animeClass/animeClassMain.jsp";
		} catch (Exception e) {
			target = "/error.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
    public void addAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        AnimeClassification animeClass  = new AnimeClassification();
        animeClass.setName(name);
        animeClass.setCreateTime(new Date());
        AnimeClassBL animeCLassBL = new AnimeClassBL();
        String target = null;
        try {
            animeCLassBL.add(animeClass);
            ServletContext context = request.getSession().getServletContext();
            response.sendRedirect(context.getContextPath()+"/display?method=animeClassMain");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error",true);
            target = "/animeClass/animeClassAdd.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(target);
            rd.forward(request, response);
        }
    }

    public void delAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("id");
        AnimeClassBL animeClassBL = new AnimeClassBL();
        String target = null;
        try {
            animeClassBL.del(username);
            ServletContext context = request.getSession().getServletContext();
            response.sendRedirect(context.getContextPath()+"/display?method=userMain");
        } catch (Exception e) {
            target = "/error.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(target);
            rd.forward(request, response);
        }
    }

}
