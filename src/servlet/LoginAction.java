package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.SystemContext;
import dao.UserDAO;
import exception.PasswordFalseException;
import exception.UserNoneException;
import bean.User;

public class LoginAction{
    UserDAO userDao = new UserDAO();
	public void action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("pwd");
		User user = new User(username,password);
		String target = null;
		try{
            List<User> dbUser = userDao.findUser(user);
            if (dbUser != null && dbUser.size() == 1
                    && dbUser.get(0).getPassword().equals(user.getPassword())
                    && dbUser.get(0).getUsername().equals(user.getUsername())) {
            } else if (dbUser != null && dbUser.size() == 1 && dbUser.get(0).getUsername().equals(user.getUsername()) && !dbUser.get(0).getPassword().equals(user.getPassword())) {
                throw new PasswordFalseException();
            } else {
                throw new UserNoneException();
            }
            request.setAttribute("passedUser",user);
            SystemContext.setUser(request.getSession(),user);
            target = "/home.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(target);
            rd.forward(request, response);
		}catch(UserNoneException e){
			request.setAttribute("errorUser","errorUser");
			target = "/login.jsp";
            //forward to view
            RequestDispatcher rd = request.getRequestDispatcher(target);
            rd.forward(request, response);
		} catch (PasswordFalseException e) {
			request.setAttribute("name", username);
			request.setAttribute("errorPassword","errorPassword");
			target = "/login.jsp";
            //forward to view
            RequestDispatcher rd = request.getRequestDispatcher(target);
            rd.forward(request, response);
		}

	}

}
