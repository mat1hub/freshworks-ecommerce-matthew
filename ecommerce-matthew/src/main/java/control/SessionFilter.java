package control;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter("*.do")
public class SessionFilter extends HttpFilter implements Filter {
 
	public void destroy() {
		// TODO Auto-generated method stub
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Inside Filter class ");
		System.out.println("|");
		System.out.println("+");
		HttpServletRequest hrequest=(HttpServletRequest)request;
		HttpSession session=hrequest.getSession();
		if(session.isNew()) {
			String formid=request.getParameter("formid");
			if(formid==null)
			{
				HttpServletResponse hresponse=(HttpServletResponse)response;
				hresponse.sendRedirect("expire.jsp");
			}
			else if(formid.equals("lang")) {
				chain.doFilter(request, response);
			}
			else {
				HttpServletResponse hresponse=(HttpServletResponse)response;
				hresponse.sendRedirect("expire.jsp");
			}
		}
		else {
			chain.doFilter(request, response);
		}
		
	}
  
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
