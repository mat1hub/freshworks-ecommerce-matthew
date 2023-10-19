package service;

import java.util.List;

import dao.shoppingcart.ShoppingCartDTO;

public interface ShoppingCartService {
	public int insertProduct(ShoppingCartDTO insert) ;
		
public List<ShoppingCartDTO> getCartItems();
public ShoppingCartDTO getActiveShoppingcart(int customerId);
}
