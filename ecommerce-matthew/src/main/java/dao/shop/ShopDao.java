package dao.shop;

import java.util.List;

public interface ShopDao {

public ShopDTO findbyShopid(int shopid);
public int insertShop(ShopDTO shop);
public int editShop(ShopDTO shop);
public int deleteShop(int shopid);
public List<ShopDTO> findAll();
}
