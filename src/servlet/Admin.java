package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Impor.NewsIndexImpor;
import dao.NewsDao;
import entity.Category;
import entity.News;
import entity.Page;

public class Admin extends HttpServlet {
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
		
	
		// 提取登陆账号和密码属性
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		this.login(req, resp, name, pwd);
			
		// 转发到util/admin.jsp
		rd.forward(req, resp);

	}

	// 到数库判断用户名和密码是否正确或存在
	private boolean checkPwd(String name, String pwd) {
		NewsIndexImpor nii = new NewsIndexImpor();
		boolean b = nii.login(name, pwd);
		return b;
	}

	private void login(HttpServletRequest req, HttpServletResponse res, String name, String pwd) {
	/*	if(req.getCookies() != null) {
			for (Cookie  c: req.getCookies()) {
				if ("userCookie".equals(c.getName())) {
					String[] str = c.getValue().split("#");
					req.getSession().setAttribute("name", str[0]);
					req.setAttribute("name", str[1]);
				} 
			}
		}*/
			
		
		// 用户名和密码为空，转发回登陆页面
		if (name == null || name.equals("")) {
			req.getSession().setAttribute("msg", "你还没有登陆，请重新登陆!!!");
			
				try {
					req.getRequestDispatcher("indexURl").forward(req, res);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			return;
		}

		// 数据库判断账号密码是否存在
		if (checkPwd(name, pwd)) {
			// 如果密码存在创建session对象并设置属性
			req.getSession().setAttribute("pwd", pwd);
			req.getSession().setAttribute("name", name);

			// 登陆时通过密码验证的第一次创建cookie实现10分钟内自动登陆
			String user= name+ "#" + pwd;
			Cookie useCookie = new Cookie("userCookie", user);
			useCookie.setMaxAge(600); // 设置cookie有效时间10分钟
			res.addCookie(useCookie);
		} else {
			req.getSession().setAttribute("msg", "用户名或密码错误，请重新登陆!!!");
			try {
				req.getRequestDispatcher("indexURl").forward(req, res);
				//res.sendRedirect("indexURl");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return;
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
