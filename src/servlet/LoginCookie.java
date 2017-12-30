package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDao;
import entity.News;
import entity.Page;
/*登陆成功后，再次登陆点击管理员页面
*/
public class LoginCookie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("util/admin.jsp");
		
		// 分页显示管理页信息
		int pageNo;
		try {
			pageNo = Integer.parseInt(req.getParameter("pageNo"));
		} catch (Exception e) {
			pageNo = 1;
		} // 忽略所有异常
		Page<News> p = NewsDao.dao.findAll(pageNo);
		req.setAttribute("Page", p);
		
		rd.forward(req, resp);
		
	}
}
