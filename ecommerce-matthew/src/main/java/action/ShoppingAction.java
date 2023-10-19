package action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingAction extends Action{
 @Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	// TODO Auto-generated method stub
	 String shopid=request.getParameter("shopid");
	 HttpSession session=request.getSession();
	 Enumeration<String> e=request.getParameterNames();
	 while(e.hasMoreElements()) {
		 String name=e.nextElement().toString();
		 String value=request.getParameter(name).toString();		 
		 session.setAttribute(name, value);		 
	 }
	return shopid+".success";
}
}
