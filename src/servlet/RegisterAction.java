package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDAO;
import exception.UserExistedException;


public class RegisterAction  {
    UserDAO userDao = new UserDAO();
    public void action(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("userName");
        String password = request.getParameter("userpwd");
        User user  = new User(username,password);
        String target = null;
        try {
            List<User> userList = userDao.findUser(user);
            if (userList != null && !userList.isEmpty()) {
                throw new UserExistedException();
            } else {
                userDao.addUser(user);
            }
            target = "/login.jsp";
        } catch (UserExistedException e) {
            target = "/register.jsp";
            request.setAttribute("error", e.toString());
            request.setAttribute("existed_user", user);
        }
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request, response);
    }

}
