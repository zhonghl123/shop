package servlet;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginOutAction {
    public void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("LOGIN_USER");
        ServletContext context = request.getSession().getServletContext();
        response.sendRedirect(context.getContextPath()+"/display?method=goHome");
    }
}
