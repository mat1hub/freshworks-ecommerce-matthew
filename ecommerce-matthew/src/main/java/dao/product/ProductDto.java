package dao.product;

public class ProductDto {
 private String productCode;
 private String productName;
 private String productDescription;
 private int quantityInStock;
 private double buyPrice;
 private double msrp;
 private String productImage;
 private int shopid;
 
  
public int getShopid() {
	return shopid;
}
public void setShopid(int shopid) {
	this.shopid = shopid;
}
public String getProductImage() {
	return productImage;
}
public void setProductImage(String productImage) {
	this.productImage = productImage;
}
public String getProductCode() {
	return productCode;
}
public void setProductCode(String productCode) {
	this.productCode = productCode;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getProductDescription() {
	return productDescription;
}
public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}
public int getQuantityInStock() {
	return quantityInStock;
}
public void setQuantityInStock(int quantityInStock) {
	this.quantityInStock = quantityInStock;
}
public double getBuyPrice() {
	return buyPrice;
}
public void setBuyPrice(double buyPrice) {
	this.buyPrice = buyPrice;
}
public double getMsrp() {
	return msrp;
}
public void setMsrp(double msrp) {
	this.msrp = msrp;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	long temp;
	temp = Double.doubleToLongBits(buyPrice);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(msrp);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
}
@Override
public String toString() {
	return "ProductDto [productCode=" + productCode + ", productName=" + productName + ", productDescription="
			+ productDescription + ", quantityInStock=" + quantityInStock + ", buyPrice=" + buyPrice + ", msrp=" + msrp
			+ "]";
}


 
 
 
}
