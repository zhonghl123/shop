package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.SystemContext;
import exception.PasswordFalseException;
import exception.UserNoneException;

import bl.UserBL;
import bo.User;

public class LoginAction{

	public void action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("pwd");
		
		
		UserBL userBl = new UserBL();
		User user = new User(username,password);
		
		String target = null;
		
		try{
			userBl.verify(user);
			request.setAttribute("passedUser",user);
            //保存登陆用户信息，跳转到管理页面
            SystemContext.setUser(request.getSession(),user);
            target = "/main.jsp";
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
