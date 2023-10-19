package service;

import dao.customer.CustomerDAO;
import dao.customer.CustomerDAOImpl;
import dao.customer.CustomerDTO;
public class CustomerServiceImpl implements CustomerService,Cloneable{
	
	private CustomerServiceImpl() {
		System.out.println("customer service impl object created...");
		
	}
	
	private static CustomerServiceImpl cs;
	
	synchronized public static CustomerServiceImpl getServiceImpl() {
		if(cs==null) {
			cs=new CustomerServiceImpl();
			return cs;
		}
		else {
			return cs.createClone();
		}
	}
	private CustomerServiceImpl createClone() {
		try {
			return (CustomerServiceImpl)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean checkFlag(String uname) {
		CustomerDAO cdao=CustomerDAOImpl.getServiceImpl();
		CustomerDTO dto=cdao.findByName(uname);
		System.out.println("dto value: "+dto);
		if(dto!=null) {
			int flagvalue=dto.getAlreadyLoggedIn();
			System.out.println("myflag value :"+flagvalue);
			if(flagvalue==0) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	@Override
	public boolean checkUser(String uname, String pwd) {
		CustomerDAO cdao=CustomerDAOImpl.getServiceImpl();
		CustomerDTO dto=cdao.findByName(uname);
		System.out.println(dto);
		if(dto!=null) {
			if(dto.getPassword().equals(pwd)) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	@Override
	public int updateFlag(int flag, String cust_name) {
		CustomerDAO cdao=CustomerDAOImpl.getServiceImpl();
		CustomerDTO dto=cdao.findByName(cust_name);
		if(dto!=null) {
			dto.setAlreadyLoggedIn(flag);
			cdao.updateCustomer(dto);
			return 1;
		}
		return 0;		
	}
	
	@Override
	public int insertCustomer(CustomerDTO dto) {
		CustomerDAO cdao=CustomerDAOImpl.getServiceImpl();
		return cdao.insertCustomer(dto);
		
		
	}
	
	
	public int editCustomer(CustomerDTO dto) {
		CustomerDAO cdao=CustomerDAOImpl.getServiceImpl();
		return cdao.updateCustomer(dto);
		
		
	}
	public CustomerDTO findByName(String customerName) {
		CustomerDAO cdao=CustomerDAOImpl.getServiceImpl();
		return cdao.findByName(customerName);
		
	}
	
	

}
