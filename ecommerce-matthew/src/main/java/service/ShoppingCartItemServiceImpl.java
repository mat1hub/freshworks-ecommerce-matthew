package service;

import java.util.List;

import dao.shoppingcart.ShoppingCartDAO;
import dao.shoppingcart.ShoppingCartDAOImpl;
import dao.shoppingcart.ShoppingCartDTO;
import dao.shoppingcartitem.ShoppingCartItemDAO;
import dao.shoppingcartitem.ShoppingCartItemDAOImp;
import dao.shoppingcartitem.ShoppingCartItemDTO;

public class ShoppingCartItemServiceImpl implements ShoppingCartItemService,Cloneable{
	
	private ShoppingCartItemServiceImpl() {
		System.out.println("ShoppingCart service item impl object created...");
		
	}
	
	private static ShoppingCartItemServiceImpl cs;
	
	synchronized public static ShoppingCartItemServiceImpl getServiceImpl() {
		if(cs==null) {
			cs=new ShoppingCartItemServiceImpl();
			return cs;
		}
		else {
			return cs.createClone();
		}
	}
	private ShoppingCartItemServiceImpl createClone() {
		try {
			return (ShoppingCartItemServiceImpl)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public List<ShoppingCartItemDTO> findAll() {
		ShoppingCartItemDAO pdao=ShoppingCartItemDAOImp.getServiceImpl();
		return pdao.findAll();
	}
	@Override
	public int addItem(ShoppingCartItemDTO addProduct) {
		ShoppingCartItemDAO pdao=ShoppingCartItemDAOImp.getServiceImpl();
		return pdao.addItem(addProduct);
	}
	@Override
	public int removeItem(ShoppingCartItemDTO removeProduct) {
		ShoppingCartItemDAO pdao=ShoppingCartItemDAOImp.getServiceImpl();
		return pdao.removeItem(removeProduct);
	}
	@Override
	public int updateItem(ShoppingCartItemDTO updateItem) {
		ShoppingCartItemDAO pdao=ShoppingCartItemDAOImp.getServiceImpl();
		return pdao.updateItem(updateItem);
	}
	@Override
	public List<ShoppingCartItemDTO> getItemsinCart(int customerId) {
		ShoppingCartItemDAO pdao=ShoppingCartItemDAOImp.getServiceImpl();
		return pdao.getItemsinCart(customerId);
	}
	

}
