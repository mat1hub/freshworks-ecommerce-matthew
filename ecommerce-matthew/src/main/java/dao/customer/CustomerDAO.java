package dao.customer;

import java.util.List;

public interface CustomerDAO {
	public CustomerDTO findByID(int uid);
	public List<CustomerDTO> findAll();
	public CustomerDTO findByName(String customerName);
	public int insertCustomer(CustomerDTO dto);
	public int updateCustomer(CustomerDTO dto);
	public int deleteCustomer(CustomerDTO dto);
}
