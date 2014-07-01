package servlet;


import bean.Brand;
import bean.Firm;
import bean.Good;
import bean.User;
import common.SystemContext;
import dao.BrandDAO;
import dao.FirmDAO;
import dao.GoodDAO;
import servlet.common.UploadAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class GoodAction {
    GoodDAO dao= new GoodDAO();
    BrandDAO brandDao = new BrandDAO();
    FirmDAO firmDao = new FirmDAO();

    public void action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Good bean = new Good();
		String target = null;
		try {
            request.setAttribute("domainList",dao.find(bean));
			target = "/good/goodMain.jsp";
		} catch (Exception e) {
			target = "/error.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
    public void addAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String,String> pathMap =UploadAction.getPath(request, response);
        String id = pathMap.get("id").toString();
        String des = pathMap.get("des").toString();
        String stock = pathMap.get("stock").toString();
        String name = pathMap.get("name");
        String brand = pathMap.get("brand");
        String firm = pathMap.get("firm");
        Good bean = new Good();
        bean.setDes(des);
        bean.setPic(pathMap.get("file"));
        bean.setPrice(Double.valueOf(pathMap.get("price")));
        bean.setStock(Integer.parseInt(stock));
        bean.setName(name);
        bean.setBrand(Integer.parseInt(brand));
        bean.setFirm(Integer.parseInt(firm));
        if(id==null||id.equals("")){
            bean.setCreate_time(new Date());
            dao.add(bean);
        }else{
            dao.update(bean);
        }
        String target = null;
        try {

            ServletContext context = request.getSession().getServletContext();
            response.sendRedirect(context.getContextPath() + "/display?method=goodMain");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", true);
            target = "/good/goodAdd.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(target);
            rd.forward(request, response);
        }
    }

    public void delAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("id");
        String target = null;
        try {
            dao.del(username);
            ServletContext context = request.getSession().getServletContext();
            response.sendRedirect(context.getContextPath()+"/display?method=goodMain");
        } catch (Exception e) {
            target = "/error.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(target);
            rd.forward(request, response);
        }
    }

    public void detailAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
       Good good = dao.findByPk(id);
        String target;
        try {
            request.setAttribute("domain",good);
            target = "/good/goodDetail.jsp";
        } catch (Exception e) {
            target = "/error.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request, response);
    }

    public void addUIAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Good good = dao.findByPk(id);
        String target;
        try {
            request.setAttribute("domain",good);
            target = "/good/goodDetail.jsp";
        } catch (Exception e) {
            target = "/error.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request, response);
    }

    public void buyAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Good good = dao.findByPk(id);
        String target;
        User user = SystemContext.getUser(request.getSession());
        try {
        if(user==null){
            request.setAttribute("info","info");
            target = "/login.jsp";
        }else{
            request.setAttribute("domain",good);
            target = "/good/goodBuy.jsp";
        }
        } catch (Exception e) {
            target = "/error.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request, response);
    }

    public void adBuyAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num = request.getParameter("num");
        String address = request.getParameter("address");
        String good_id = request.getParameter("good_id");
        String userId = SystemContext.getUser(request.getSession()).getUsername();
        dao.addBuyInfo(num,address,good_id,userId);
        String target;
        Double price = dao.findByPk(good_id).getPrice();
        Double totalPrice =Integer.parseInt(num)*price;
        try {
            request.setAttribute("totalPrice",totalPrice);
            target = "/good/buyInfo.jsp";
        } catch (Exception e) {
            target = "/error.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request, response);
    }
}
