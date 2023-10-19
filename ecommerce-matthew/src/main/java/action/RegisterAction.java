package action;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import dao.customer.CustomerDTO;
import service.CustomerService;
import service.CustomerServiceImpl;

public class RegisterAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		CustomerService cs=CustomerServiceImpl.getServiceImpl();
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
		CustomerDTO dto=new CustomerDTO();
		dto.setCustomerid((int)(Math.random() * 10000) + 1);
		dto.setCustomername(uname);
		dto.setPassword(upass);
		dto.setActiveFlag(1);;
		cs.insertCustomer(dto);
		return "lang.success";
		
		
	}
}
