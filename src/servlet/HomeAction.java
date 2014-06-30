package servlet;


import bl.AnimeClassBL;
import bl.UserBL;
import bo.AnimeClassification;
import bo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeAction {
    public void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AnimeClassBL animeClassBL = new AnimeClassBL();
        String target = null;

        try {
            request.setAttribute("animeClassList",animeClassBL.find(new AnimeClassification()));
            target = "/home.jsp";
        } catch (Exception e) {
            target = "/error.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request, response);
    }
}
