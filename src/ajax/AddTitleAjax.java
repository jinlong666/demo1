package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dao.TopicDao;

public class AddTitleAjax extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		//System.out.println(name);
		name = new String(name.getBytes("ISO-8859-1"),"UTF-8");//解决乱码问题 
		System.out.println(name);
		boolean bool = TopicDao.dao.findTitle(name);
		PrintWriter out = resp.getWriter();
		out.print(bool);
		out.flush();
		//out.close();
	}
}
