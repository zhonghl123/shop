package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.UserNoneException;

import bl.UserBL;
import bo.User;

public class ResetPasswordAction{

	public void action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("userName");
		String idNumber = request.getParameter("number");
		String userpwd = request.getParameter("userpwd");
		
		UserBL userBL = new UserBL();
		User user = new User(name, userpwd, idNumber);
		
		String target = null;
		try {
			userBL.resetPwd(user);
			request.setAttribute("passedUser", user);
			target="/login.jsp";
		} catch (UserNoneException e) {
			request.setAttribute("error", e.toString());
			target="/resetPassword.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

}
