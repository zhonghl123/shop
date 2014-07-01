package servlet;


import bean.Firm;
import dao.GoodDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeAction {
    GoodDAO dao = new GoodDAO();
    public void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String target = null;
        request.setAttribute("domainList",dao.find(null));
        try {
            target = "/home.jsp";
        } catch (Exception e) {
            target = "/error.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request, response);
    }
}
