package action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.customer.CustomerDAOImpl;
import service.CustomerService;
import service.CustomerServiceImpl;

public class LoginAction extends Action implements Cloneable{
	
	public LoginAction() {
		System.out.println("Login Action impl object created...");
	}
	
	private static LoginAction cs;
	
	synchronized public static LoginAction getServiceImpl() {
		if(cs==null) {
			cs=new LoginAction();
			return cs;
		}
		else {
			return cs.createClone();
		}
	}
	private LoginAction createClone() {
		try {
			return (LoginAction)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	String uname=request.getParameter("username");
	String upass=request.getParameter("password");
//	System.out.println("un: "+uname);
//	System.out.println("up: "+upass);
	CustomerService cs=CustomerServiceImpl.getServiceImpl();
	if(cs.checkUser(uname,upass)) {
		if(cs.checkFlag(uname)) {
			HttpSession session=request.getSession();
			session.setAttribute("uname", uname);
			cs.updateFlag(1, uname);
			return "login.success";
		}
		else {
			return "login.alreadylogedin";
		}
	}
	else {
		return "login.register";
	}
	
}
}
