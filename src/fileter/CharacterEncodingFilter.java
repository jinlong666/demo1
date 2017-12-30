package fileter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class CharacterEncodingFilter implements Filter{
	private static Logger log = Logger.getLogger(CharacterEncodingFilter.class);
	private String cha;
	@Override
	public void destroy() {
		log.info("CharacterEncodingFilter销毁了");
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		log.info("CharacterEncodingFilter服务了");
		HttpServletRequest req = (HttpServletRequest) arg0;
		System.out.println("请求地址"+ req.getServletPath());
		if (cha != null) {
			arg0.setCharacterEncoding("UTF-8");
			arg1.setCharacterEncoding("UTF-8");
		}
		
		arg2.doFilter(arg0, arg1);	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		log.info("CharacterEncodingFilter初始化了");
		cha = arg0.getInitParameter("encoding");
	}

}
