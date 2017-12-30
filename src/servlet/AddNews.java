package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Locale.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Impor.NewsIndexImpor;
import dao.CommentsDao;
import dao.TopicDao;
import entity.Comments;
import entity.News;

public class AddNews  extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("util/add_news.jsp");
	
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		req.setAttribute("name", req.getParameter("name"));
		TopicDao tp =  new TopicDao();
		List<entity.Category> list = tp.findAllTitle();
		req.setAttribute("list", list);
		
		 rd.forward(req,resp); 
		

       	
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
}
