package servlet;

import servlet.common.DownloadAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跳转servlet
 */
public class DisplayServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathName = request.getParameter("path");
        if (pathName != null && !"".equals(pathName)) {
            RequestDispatcher rd = request.getRequestDispatcher(pathName);
            rd.forward(request, response);
        }
        String methodName = request.getParameter("method");
        if ("messageCtrl".equals(methodName)) {
            new MessageCtrlAction().action(request, response);
        } else if ("login".equals(methodName)) {
            new LoginAction().action(request, response);
        } else if ("resetPassword".equals(methodName)) {
            new ResetPasswordAction().action(request, response);
        } else if ("register".equals(methodName)) {
            new RegisterAction().action(request, response);
        } else if ("userMain".equals(methodName)) {    //进入用户管理界面
            new UserAction().action(request, response);
        } else if ("addUser".equals(methodName)) {    //进入用户管理界面
            new UserAction().addAction(request, response);
        }else if ("delUser".equals(methodName)) {    //进入用户管理界面
            new UserAction().delAction(request, response);
        } else if ("commentMain".equals(methodName)) {    //进入评论管理界面
            new CommentAction().action(request, response);
        } else if ("animeMain".equals(methodName)) {    //进入动漫管理界面
            new AnimeAction().action(request, response);
        } else if ("addAnime".equals(methodName)) {    //进入动漫管理界面
            new AnimeAction().addAction(request, response);
        } else if ("addUIAnime".equals(methodName)) {    //进入动漫管理界面
            new AnimeAction().addUIAction(request, response);
        }else if ("delAnime".equals(methodName)) {    //进入动漫管理界面
            new AnimeAction().delAction(request, response);
        } else if ("detailAnime".equals(methodName)) {    //进入动漫管理界面
            new AnimeAction().detailAction(request, response);
        } else if ("animeClassMain".equals(methodName)) {    //进入动漫分类管理界面
            new AnimeClassAction().action(request, response);
        } else if ("addAnimeClass".equals(methodName)) {    //进入动漫分类管理界面
            new AnimeClassAction().addAction(request, response);
        } else if ("delAnimeClass".equals(methodName)) {    //进入动漫分类管理界面
            new AnimeClassAction().delAction(request, response);
        } else if ("replyMain".equals(methodName)) {    //进入回复管理界面
            new ReplyAction().action(request, response);
        } else if ("goHome".equals(methodName)) {    //进入回复管理界面
            new HomeAction().action(request, response);
        }  else if ("download".equals(methodName)) {    //进入回复管理界面
            new DownloadAction().download(request, response);
        }else if ("loginout".equals(methodName)) {    //进入回复管理界面
            new LoginOutAction().action(request, response);
        }else if ("animeDetail".equals(methodName)) {    //进入回复管理界面
            new AnimeAction().animeDetailAction(request, response);
        }else if ("addUIComment".equals(methodName)) {    //进入回复管理界面
            new CommentAction().addUIAction(request, response);
        }else if ("addComment".equals(methodName)) {    //进入回复管理界面
            new CommentAction().addAction(request, response);
        }else if ("addReply".equals(methodName)) {    //进入回复管理界面
            new ReplyAction().addAction(request, response);
        } else if ("addUIReply".equals(methodName)) {    //进入回复管理界面
            new ReplyAction().addUIAction(request, response);
        }
    }
}
