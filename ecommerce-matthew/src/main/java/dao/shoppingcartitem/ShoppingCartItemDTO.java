package dao.shoppingcartitem;

import java.sql.Date;
import java.util.Objects;

public class ShoppingCartItemDTO {
	private int shoppingcartitemid;
	private int shoppingcartid;
	private String productcode;
	private int quantity;
	private int isactive;
	private Date lastupdateddate;
	private int shopid;
	private String productName;
	private String productImage;
	private double price;
	
	
	
	
	
	
    
public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
public int getShoppingcartitemid() {
	return shoppingcartitemid;
}
public void setShoppingcartitemid(int shoppingcartitemid) {
	this.shoppingcartitemid = shoppingcartitemid;
}
public int getShoppingcartid() {
	return shoppingcartid;
}
public void setShoppingcartid(int shoppingcartid) {
	this.shoppingcartid = shoppingcartid;
}
public String getProductcode() {
	return productcode;
}
public void setProductcode(String productcode) {
	this.productcode = productcode;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getIsactive() {
	return isactive;
}
public void setIsactive(int isactive) {
	this.isactive = isactive;
}
public Date getLastupdateddate() {
	return lastupdateddate;
}
public void setLastupdateddate(Date lastupdateddate) {
	this.lastupdateddate = lastupdateddate;
}
@Override
public String toString() {
	return "ShoppingCartItemDTO [shoppingcartitemid=" + shoppingcartitemid + ", shoppingcartid=" + shoppingcartid
			+ ", productcode=" + productcode + ", quantity=" + quantity + ", isactive=" + isactive
			+ ", lastupdateddate=" + lastupdateddate + "]";
}
@Override
public int hashCode() {
	return Objects.hash(isactive, lastupdateddate, productcode, quantity, shoppingcartid, shoppingcartitemid);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ShoppingCartItemDTO other = (ShoppingCartItemDTO) obj;
	return isactive == other.isactive && Objects.equals(lastupdateddate, other.lastupdateddate)
			&& Objects.equals(productcode, other.productcode) && quantity == other.quantity
			&& shoppingcartid == other.shoppingcartid && shoppingcartitemid == other.shoppingcartitemid;
}




}
