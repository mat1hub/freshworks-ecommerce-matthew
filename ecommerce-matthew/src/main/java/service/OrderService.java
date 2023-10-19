package service;

import java.util.List;

import dao.order.OrderDTO;
public interface OrderService {
	
	public List<OrderDTO> getOrders(int customerId);
	public int placeOrder(int shoppingCartId);
}
