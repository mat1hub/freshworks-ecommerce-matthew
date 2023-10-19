package dao.product;

import java.util.List;

import dao.product.ProductDto;

public interface ProductDao {
public ProductDto findByProductCode(String pcode);
public List<ProductDto> findAll();
public ProductDto findByproductName(String pname);
public int insertProduct(ProductDto pto);
public int updateProduct(ProductDto pto);
public int deleteProduct(String productCode);
public List<ProductDto> showProductByShopId(int shopid);
}
