package servlet;


import bl.CommentBL;
import bl.ReplyBL;
import bl.UserBL;
import bo.Reply;
import bo.User;
import exception.UserExistedException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class ReplyAction {
    public void addAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer animeId = Integer.parseInt(request.getParameter("animeId"));
        Integer commentId = Integer.parseInt(request.getParameter("commentId"));
        String content = request.getParameter("content");
        Reply reply = new Reply();
        reply.setContent(content);
        reply.setInputer(((User) request.getSession().getAttribute("LOGIN_USER")).getUsername());
        reply.setAnimeId(animeId);
        reply.setCommentId(commentId);
        reply.setCreateTime(new Date());
        ReplyBL userBL = new ReplyBL();
        String target = null;
        try {
            userBL.add(reply);
            ServletContext context = request.getSession().getServletContext();
            response.sendRedirect(context.getContextPath() + "/display?method=commentMain");
        } catch (Exception e) {
            target = "/error.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(target);
            rd.forward(request, response);
        }
    }
    public void action(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ReplyBL userBL = new ReplyBL();
        String target = null;

        try {
            request.setAttribute("domainList",userBL.find(new Reply()));
            target = "/reply/replyMain.jsp";
        } catch (Exception e) {
            target = "/error.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request, response);
    }

    public void addUIAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String animeId = request.getParameter("animeId");
        String commentId = request.getParameter("commentId");
        request.setAttribute("animeId",animeId);
        request.setAttribute("commentId",commentId);
        RequestDispatcher rd = request.getRequestDispatcher("/reply/replyAdd.jsp");
        rd.forward(request, response);
    }
}
