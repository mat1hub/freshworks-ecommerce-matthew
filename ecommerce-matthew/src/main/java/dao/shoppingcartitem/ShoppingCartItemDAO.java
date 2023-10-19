package dao.shoppingcartitem;

import java.util.List;


public interface ShoppingCartItemDAO {
public List<ShoppingCartItemDTO> findAll();
public int addItem(ShoppingCartItemDTO addProduct);
public int removeItem(ShoppingCartItemDTO removeProduct);
public int updateItem(ShoppingCartItemDTO updateItem);
public List<ShoppingCartItemDTO> getItemsinCart(int customerId);

}
