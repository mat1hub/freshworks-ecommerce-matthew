package action;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.ProductServiceImpl;
import service.ProductService;



public class LandingAction extends Action implements Cloneable{
	
	public LandingAction() {
		System.out.println("Landing Action impl object created...");
	}
	
	
	
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	String page=request.getParameter("page");
	System.out.println(page);
	request.setAttribute("page", page);
	//setting the products list values 
	ProductService ps=ProductServiceImpl.getServiceImpl();
	request.setAttribute("productList", ps.getProducts());
	
	return "landing.success";

}
}
