package servlet;

import bl.UserBL;
import bo.User;
import exception.UserExistedException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAction {

    public void action(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pageNumberStr = request.getParameter("pageNumber");
        int pageNumber = 1;
        if (pageNumberStr != null && !pageNumberStr.isEmpty()) {
            pageNumber = Integer.parseInt(pageNumberStr);
        }
        int pageSize = 10; //分页大小
        String username = request.getParameter("username");
        String idNumber = request.getParameter("idname");
        User user = new User();
        user.setUsername(username);
        user.setIdname(idNumber);
        UserBL userBL = new UserBL();
        String target = null;

        try {
            request.setAttribute("userList", userBL.find(user, pageSize, pageNumber));
            int totalPosts = userBL.findCount(user); //总文章数
            int totalPages = totalPosts / pageSize + ((totalPosts % pageSize) > 0 ? 1 : 0); //计算得出的总页数
            request.setAttribute("pageSize", pageSize);
            request.setAttribute("totalPosts", totalPosts);
            request.setAttribute("pageNumber", pageNumber);
            request.setAttribute("totalPages", totalPages);
            //查询条件
            request.setAttribute("username",username);
            request.setAttribute("idname",idNumber);
            target = "/user/userMain.jsp";
        } catch (Exception e) {
            target = "/error.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request, response);
    }

    public void addAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String idname = request.getParameter("idname");
        User user = new User(username, password, idname);
        UserBL userBL = new UserBL();
        String target = null;
        try {
            userBL.register(user);
            ServletContext context = request.getSession().getServletContext();
            response.sendRedirect(context.getContextPath() + "/display?method=userMain");
        } catch (UserExistedException e) {
            request.setAttribute("userexsit", true);
            target = "/user/userAdd.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(target);
            rd.forward(request, response);
        }
    }

    public void delAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("id");
        UserBL userBL = new UserBL();
        String target = null;
        try {
            userBL.del(username);
            ServletContext context = request.getSession().getServletContext();
            response.sendRedirect(context.getContextPath() + "/display?method=userMain");
        } catch (Exception e) {
            target = "/error.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(target);
            rd.forward(request, response);
        }
    }
}
