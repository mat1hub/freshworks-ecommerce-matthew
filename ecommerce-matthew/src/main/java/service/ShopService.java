package service;

import java.util.List;

import dao.shop.ShopDTO;

public interface ShopService {
	public ShopDTO findbyShopid(int shopid);
	public int insertShop(ShopDTO product);
	public int editShop(ShopDTO product);
	public int deleteShop(int shopid);
	public List<ShopDTO> findAll();

}
