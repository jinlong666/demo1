package fileter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mistiming implements Filter {
	private long starTime ; //请求时间
	private long endTime ;	//响应时间
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		starTime = System.nanoTime();   // System.nanoTime()获得系统当前时间  [毫微秒] //或者 System.currentTimeMillis()【毫秒数】
		arg2.doFilter(arg0,arg1);
		endTime = System.nanoTime();
		System.out.println("请求响应毫微秒差：" + (endTime-starTime) );
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
