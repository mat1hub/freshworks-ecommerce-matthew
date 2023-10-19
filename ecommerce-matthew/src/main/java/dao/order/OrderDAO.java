package dao.order; 

import java.util.List;


public  interface  OrderDAO {
	public List<OrderDTO> findAll(int customerid);
	public OrderDTO findByOrderId(int pname);
	public int addOrder(OrderDTO  insert);
	public int updateOrder(OrderDTO  update);
	public int deleteOrder(OrderDTO  delete);
	public int placeOrder(int shoppingCartId);
}
