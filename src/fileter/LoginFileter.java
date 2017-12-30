package fileter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class LoginFileter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest hs = (HttpServletRequest) arg0;
	
		if(hs.getCookies() != null) {
			for (Cookie  c: hs.getCookies()) {
				if ("userCookie".equals(c.getName())) {
					String[] str = c.getValue().split("#");
					hs.getSession().setAttribute("name", str[0]);
					hs.setAttribute("name", str[0]);
					arg2.doFilter(arg0, arg1);
					return;
				} 
			}
		}
		
		String path=hs.getServletPath();  //获取请求的url
		System.out.println("请求的地址>>>>>>"+path);
		//遇到这些页面直接放行，跳出过滤器
		if(path.equals("/index.jsp")||path.equals("/indexURl")||path.equals("/adminURl")||path.endsWith(".js")||
				path.endsWith(".jpg")||path.endsWith(".gif")||path.endsWith(".css")||
				path.endsWith(".js")) {
			arg2.doFilter(hs, arg1);
			return;
		}

		String pwd = (String)hs.getSession().getAttribute("pwd");
		String name = (String)hs.getSession().getAttribute("name");
		
		//session中没有登录信息跳回登录页
		if(name == null || pwd == null) {
			hs.getSession().setAttribute("msg", "你还没有登陆，请重新登陆!!!");
			hs.getRequestDispatcher("indexURl").forward(arg0, arg1);	
			return;
		}
		
		//用户名和密码不为空且用户名和密码都正确则通过滤器
		arg2.doFilter(arg0, arg1);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
