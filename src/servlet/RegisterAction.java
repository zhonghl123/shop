package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.UserExistedException;

import bl.UserBL;
import bo.User;

public class RegisterAction  {

	public void action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("userName");
		String password = request.getParameter("userpwd");
		String idNumber = request.getParameter("idNumber");
		
		User user  = new User(username,password,idNumber);
		UserBL userBL = new UserBL();
		String target = null;

		try {
			userBL.register(user);
			target = "/login.jsp";
		} catch (UserExistedException e) {
			target = "/register.jsp";
			request.setAttribute("error", e.toString());
			request.setAttribute("existed_user", user);
		}
		//ת����Ӧҳ��
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

}
