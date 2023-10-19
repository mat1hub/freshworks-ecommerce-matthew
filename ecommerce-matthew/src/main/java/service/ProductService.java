package service;

import java.util.List;

import dao.product.ProductDto;
import dao.shop.ShopDTO;

public interface ProductService {
    
	public List<ProductDto> getProducts();
	public ProductDto findByProductCode(String pcode);
	public ProductDto findByproductName(String pname);
	public int insertProduct(ProductDto pto);
	public int updateProduct(ProductDto pto);
	public int deleteProduct(String productCode);
	public List<ProductDto> showProductByShopId(int shopid);
}
