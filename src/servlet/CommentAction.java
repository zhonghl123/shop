package servlet;

import bl.CommentBL;
import bl.UserBL;
import bo.Comment;
import bo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class CommentAction {

    public void action(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CommentBL commentBL = new CommentBL();
        String target = null;
        try {
            request.setAttribute("domainList",commentBL.find(new Comment()));
            target = "/comment/commentMain.jsp";
        } catch (Exception e) {
            target = "/error.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request, response);
    }
    public void addAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer animeId = Integer.parseInt(request.getParameter("id"));
        String content = request.getParameter("content");
        Comment comment = new Comment();
        comment.setAnimeId(animeId);
        comment.setCreateTime(new Date());
        comment.setInputer(((User) request.getSession().getAttribute("LOGIN_USER")).getUsername());
        comment.setContent(content);
        CommentBL commentBL = new CommentBL();
        String target = null;
        try {
            commentBL.add(comment);
            ServletContext context = request.getSession().getServletContext();
            target = "/display?method=goHome";
            response.sendRedirect(context.getContextPath()+target);
        } catch (Exception e) {
            target = "/error.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(target);
            rd.forward(request, response);
        }
    }

    public void addUIAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        RequestDispatcher rd = request.getRequestDispatcher("/comment/commentAdd.jsp");
        rd.forward(request, response);
    }
}
