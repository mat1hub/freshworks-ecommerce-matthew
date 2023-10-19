package service;

import java.util.List;
import dao.product.ProductDao;
import dao.product.ProductDaoImpl;
import dao.product.ProductDto;
import dao.shoppingcart.ShoppingCartDAO;
import dao.shoppingcart.ShoppingCartDAOImpl;
import dao.shoppingcart.ShoppingCartDTO;

public class ShoppingCartServiceImpl implements ShoppingCartService,Cloneable{
	private ShoppingCartServiceImpl() {
		System.out.println("ShoppingCart service impl object created...");
		
	}
	
	private static ShoppingCartServiceImpl cs;
	
	synchronized public static ShoppingCartServiceImpl getServiceImpl() {
		if(cs==null) {
			cs=new ShoppingCartServiceImpl();
			return cs;
		}
		else {
			return cs.createClone();
		}
	}
	private ShoppingCartServiceImpl createClone() {
		try {
			return (ShoppingCartServiceImpl)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public List<ShoppingCartDTO> getCartItems() {
		ShoppingCartDAO pdao=ShoppingCartDAOImpl.getServiceImpl();
		List<ShoppingCartDTO> dto=pdao.findAll();
		return dto;
	}
	@Override
	public int insertProduct(ShoppingCartDTO insert) {
		ShoppingCartDAO sdao =ShoppingCartDAOImpl.getServiceImpl();
		return sdao.insertProduct(insert);
	}
	@Override
	public ShoppingCartDTO getActiveShoppingcart(int customerId) {
		ShoppingCartDAO sdao =ShoppingCartDAOImpl.getServiceImpl();
		return sdao.getActiveShoppingcart(customerId);
	}

}
