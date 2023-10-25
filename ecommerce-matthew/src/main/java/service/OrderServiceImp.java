package service;

import java.util.List;

import dao.order.OrderDAO;
import dao.order.OrderDAOImpl;
import dao.order.OrderDTO;
import dao.product.ProductDao;
import dao.product.ProductDaoImpl;
import dao.product.ProductDto;

public class OrderServiceImp implements OrderService,Cloneable {
	private static OrderServiceImp cs;
	
	synchronized public static OrderServiceImp getOrderImp() {
		if(cs==null) {
			cs=new OrderServiceImp();
			return cs;
		}
		else {
			return cs.createClone();
		}
	}
	private OrderServiceImp createClone() {
		try {
			return (OrderServiceImp)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

		public List<OrderDTO> getOrders(int customerId) {
		    OrderDAO pdao=OrderDAOImpl.getServiceImpl();
			List<OrderDTO> dto=pdao.findAll(customerId);
			return dto;
		}
		@Override
		public int placeOrder(int shoppingCartId) {
			 OrderDAO pdao=OrderDAOImpl.getServiceImpl();
			 return pdao.placeOrder(shoppingCartId);
		}
	}


