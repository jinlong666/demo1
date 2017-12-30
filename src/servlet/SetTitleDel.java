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

public class SetTitleDel extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		     	
	    	RequestDispatcher rd = req.getRequestDispatcher("SetTitleURl");
	    	
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html;charset=UTF-8");
			req.setAttribute("name", req.getParameter("name"));
			
			//删除标题
	    	int r=TopicDao.dao.del(req.getParameter("id"));
	    	if (r < 0) {
	    		System.out.println("删除失败");
	    		resp.sendRedirect("AddTitleURl");
	    		return;
	    	} else {
	    		System.out.println("删除成功！");
	    	}
			 rd.forward(req,resp); 
	       	

	}
}
