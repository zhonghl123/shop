package servlet;

import servlet.common.DownloadAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * jump servlet
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
        if ("login".equals(methodName)) {
            new LoginAction().action(request, response);
        } else if ("register".equals(methodName)) {
            new RegisterAction().action(request, response);
        }else if ("goodMain".equals(methodName)) {    
            new GoodAction().action(request, response);
        } else if ("addGood".equals(methodName)) {    
            new GoodAction().addAction(request, response);
        } else if ("addUIGood".equals(methodName)) {    
            new GoodAction().addUIAction(request, response);
        }else if ("delGood".equals(methodName)) {    
            new GoodAction().delAction(request, response);
        } else if ("detailGood".equals(methodName)) {    
            new GoodAction().detailAction(request, response);
        } else if ("firmMain".equals(methodName)) {    
            new FirmAction().action(request, response);
        } else if ("addFirm".equals(methodName)) {    
            new FirmAction().addAction(request, response);
        } else if ("delFirm".equals(methodName)) {    
            new FirmAction().delAction(request, response);
        }else if ("brandMain".equals(methodName)) {    
            new BrandAction().action(request, response);
        } else if ("addBrand".equals(methodName)) {    
            new BrandAction().addAction(request, response);
        } else if ("goHome".equals(methodName)) {    
            new HomeAction().action(request, response);
        }  else if ("download".equals(methodName)) {    
            new DownloadAction().download(request, response);
        }else if ("loginout".equals(methodName)) {    
            new LoginOutAction().action(request, response);
        }
    }
}
