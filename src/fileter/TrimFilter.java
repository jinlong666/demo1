package fileter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class TrimFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest hs = (HttpServletRequest) arg0;
		arg2.doFilter(new RemoveBlank(hs), arg1);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	//内部类
	class RemoveBlank extends HttpServletRequestWrapper {
		// 将request交给父类，以便于调用对应方法的时候，将其输出，  
		public RemoveBlank(HttpServletRequest request) {
			super(request);
			// TODO Auto-generated constructor stub
		}
		 
		@Override
		public String getParameter(String name) {
			return super.getParameter(name).trim();
		}
		
		@Override
		public String[] getParameterValues(String name) {
			String[] str = super.getParameterValues(name);
			for (String s : str) {
				s=s.trim();
			}
			return str;
		}
		@Override
		public Map<String, String[]> getParameterMap() {
			return super.getParameterMap();
			
		}
	}
	
}
