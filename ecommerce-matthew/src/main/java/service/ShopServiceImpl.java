package service;

import java.util.List;

import dao.product.ProductDao;
import dao.product.ProductDaoImpl;
import dao.shop.ShopDTO;
import dao.shop.ShopDao;
import dao.shop.ShopDaoImpl;

public class ShopServiceImpl implements ShopService,Cloneable{
	
	public ShopServiceImpl() {
	
		System.out.println("ShopService service impl object created...");
		
	}
	
	private static ShopServiceImpl ss;
	
	synchronized public static ShopServiceImpl getServiceImpl() {
		if(ss==null) {
			ss=new ShopServiceImpl();
			return ss;
		}
		else {
			return ss.createClone();
		}
	}
	private ShopServiceImpl createClone() {
		try {
			return (ShopServiceImpl)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public ShopDTO findbyShopid(int shopid) {
		ShopDao sdao=ShopDaoImpl.getServiceImpl();
		return sdao.findbyShopid(shopid);

	}
	@Override
	public int insertShop(ShopDTO shop) {
		ShopDao sdao=ShopDaoImpl.getServiceImpl();
		return sdao.insertShop(shop);
	}
	@Override
	public int editShop(ShopDTO shop) {
		ShopDao sdao=ShopDaoImpl.getServiceImpl();
		return sdao.editShop(shop);
	}
	@Override
	public int deleteShop(int shopid) {
		ShopDao sdao=ShopDaoImpl.getServiceImpl();
		return sdao.deleteShop(shopid);
	}
	@Override
	public List<ShopDTO> findAll() {
		ShopDao sdao=ShopDaoImpl.getServiceImpl();
		return sdao.findAll();
	}
}