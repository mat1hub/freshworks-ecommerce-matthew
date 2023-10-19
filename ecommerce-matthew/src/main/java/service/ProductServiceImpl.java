package service;

import java.util.List;
import dao.product.ProductDao;
import dao.product.ProductDaoImpl;
import dao.product.ProductDto;

public class ProductServiceImpl implements ProductService,Cloneable{
	
	public ProductServiceImpl() {
		System.out.println("ProductService service impl object created...");
		
	}
	
	private static ProductServiceImpl cs;
	
	synchronized public static ProductServiceImpl getServiceImpl() {
		if(cs==null) {
			cs=new ProductServiceImpl();
			return cs;
		}
		else {
			return cs.createClone();
		}
	}
	private ProductServiceImpl createClone() {
		try {
			return (ProductServiceImpl)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public List<ProductDto> getProducts() {
		ProductDao pdao=ProductDaoImpl.getServiceImpl();
		List<ProductDto> dto=pdao.findAll();
		return dto;
	}
	@Override
	public ProductDto findByProductCode(String pcode) {
		ProductDao pdao=ProductDaoImpl.getServiceImpl();
		return pdao.findByProductCode(pcode);
	}
	
	@Override
	public ProductDto findByproductName(String pname) {
		ProductDao pdao=ProductDaoImpl.getServiceImpl();
		return pdao.findByproductName(pname);
	}
	@Override
	public int insertProduct(ProductDto pto) {
		ProductDao pdao=ProductDaoImpl.getServiceImpl();
		return pdao.insertProduct(pto);
	}
	@Override
	public int updateProduct(ProductDto pto) {
		ProductDao pdao=ProductDaoImpl.getServiceImpl();
		return pdao.updateProduct(pto);
	}
	@Override
	public int deleteProduct(String productCode) {
		ProductDao pdao=ProductDaoImpl.getServiceImpl();
		return pdao.deleteProduct(productCode);
	}
	@Override
	public List<ProductDto> showProductByShopId(int shopid) {
		ProductDao pdao=ProductDaoImpl.getServiceImpl();
		return pdao.showProductByShopId(shopid);
	}
	
}
