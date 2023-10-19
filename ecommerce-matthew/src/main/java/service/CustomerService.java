package service;

import dao.customer.CustomerDTO;

public interface CustomerService {
	public boolean checkUser(String uname,String pwd);
	public int updateFlag(int flag,String cust_name);
	public boolean checkFlag(String uname);
	public int insertCustomer(CustomerDTO dto);
	public int editCustomer(CustomerDTO dto);
	public CustomerDTO findByName(String customerName);
}
