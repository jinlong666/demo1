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

public class AddTitle  extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("SetTitleURl");
	
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		req.setAttribute("name", req.getParameter("name"));
		//添加标题
		String str = req.getParameter("title");
		System.out.println("）））））"+str);
    	int add = TopicDao.dao.addTitle(str);
    	if (add < 0) {
    		System.out.println("添加失败");
    		req.getRequestDispatcher("add_title.jsp").forward(req, resp);
    		return;
    	} else {
    		System.out.println("添加成功！");
    	}
		

		 rd.forward(req,resp); 
       	
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
}
