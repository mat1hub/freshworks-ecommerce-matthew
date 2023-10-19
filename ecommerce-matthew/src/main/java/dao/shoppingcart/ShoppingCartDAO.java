package dao.shoppingcart;

import java.util.List;



public interface ShoppingCartDAO {
	public ShoppingCartDTO findByProductCode(String productcode);
	public List<ShoppingCartDTO> findAll();
	public ShoppingCartDTO findByCustomerId(int customerid);
	public int insertProduct(ShoppingCartDTO insert);
	public int updateProduct(ShoppingCartDTO update);
	public int deleteProduct(ShoppingCartDTO delete);
	public ShoppingCartDTO getActiveShoppingcart(int customerId);
}
