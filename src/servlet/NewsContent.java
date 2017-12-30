package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Impor.NewsIndexImpor;
import dao.CommentsDao;
import dao.NewsDao;
import entity.Category;
import entity.Comments;
import entity.News;
import entity.Page;

public class NewsContent extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("util/News.jsp");
	
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
	
		NewsIndexImpor nii = new NewsIndexImpor();
		List<News> list1 = nii.sidebar(1); //首页左侧置顶国内新闻
		req.setAttribute("list1", list1);
		List<News> list2 = nii.sidebar(2); //首页左侧置顶国际新闻
		req.setAttribute("list2", list2);
		List<News> list3 = nii.sidebar(3); //首页左侧置顶娱乐新闻
		req.setAttribute("list3", list3);
		
       	 //点击新闻标题连接 ，显示内容
       	 String id = req.getParameter("id");  
   		 List<News> list = nii.content(id); 
		 req.setAttribute("list", list.get(0));
		 
		 List<Comments> comlist = CommentsDao.dao.findComments(id);	// 获取某一条新闻下的评论 //此处取评论有缺陷（只能区分同一个分类号下的品论）
		 req.setAttribute("nid", id);
		 req.setAttribute("comlist", comlist);
		 req.setAttribute("comSize", comlist.size());
		
		 rd.forward(req,resp); 
		

       	
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
}
