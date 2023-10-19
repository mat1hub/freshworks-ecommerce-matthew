package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CustomerService;
import service.CustomerServiceImpl;

public class LogoutAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String uname=session.getAttribute("uname").toString();
		CustomerService cs=CustomerServiceImpl.getServiceImpl();
		cs.updateFlag(0, uname);
		return "logout.success";
	}
}
