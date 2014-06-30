package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bl.AnimeClassBL;
import bo.InterView;

public class MessageCtrlAction {
	public void action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("userName");
		String intro =request.getParameter("intro");
		InterView iv = new InterView(name, intro);
		AnimeClassBL goodsbl = new AnimeClassBL();
		goodsbl.addInterview(iv);
	}
}
