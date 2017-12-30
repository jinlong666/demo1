package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TopicDao;
import entity.Category;
import entity.Page;

public class SetTitle  extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("util/set_title.jsp");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		 req.setAttribute("name", req.getParameter("name"));
     	  int pageNo=1;
     	  try{
     		  pageNo=Integer.parseInt(req.getParameter("pageNo"));
     	  }catch(Exception e){}//忽略所有异常
     	  Page<Category> p=TopicDao.dao.findAllTitle(pageNo); 
     	  req.setAttribute("Page", p);

		 rd.forward(req,resp); 
		

       	
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
}
