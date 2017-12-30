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

public class IndexNews extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
	
		//req.setCharacterEncoding("UTF-8");
		//resp.setContentType("text/html;charset=UTF-8");
	
		NewsIndexImpor nii = new NewsIndexImpor();
		List<News> list1 = nii.sidebar(1); //首页左侧置顶国内新闻
		req.setAttribute("list1", list1);
		List<News> list2 = nii.sidebar(2); //首页左侧置顶国际新闻
		req.setAttribute("list2", list2);
		List<News> list3 = nii.sidebar(3); //首页左侧置顶娱乐新闻
		req.setAttribute("list3", list3);
		
		List<Category> listAll = nii.getAllNews();  //首页中间所有标题分类
		//req.getRequestDispatcher("index.jsp").include(req, resp);
		req.setAttribute("listAll", listAll);
		
		//分页功能和点击标题切换功能
		int nid=1;//根据新闻分类号展示相应新闻列表
		try{
   			 nid=Integer.parseInt(req.getParameter("nid"));  //取所有分类标题中的超链接携带的id
   		}catch(Exception e){}
		req.setAttribute("nid", nid);
		 int pageNo=1;
       	 try{
       		  pageNo=Integer.parseInt(req.getParameter("pageNo")); //取下面的页号指标来显示相应的页数内容
       	 }catch(Exception e){}//忽略所有异常 	
       	 Page<News> p=NewsDao.dao.showNewsByTopic(pageNo,nid);//根据页码获得当前页面对象
       	 req.setAttribute("Page", p);
 	
		
		//Page<News> p=NewsDao.dao.showNewsByTopic(pageNo,id);//根据页码获得当前页面对象
		
       	rd.forward(req, resp);
       	
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
