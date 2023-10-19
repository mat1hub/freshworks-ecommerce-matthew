package dao.shop;

import java.util.Date;
import java.util.Objects;

public class ShopDTO {
 
 private int shopid;
 private String shopOwner;
 private String shopType;
 private String address;
 private String city;
 private String pincode;
 private int active;
 private Date lastUpdatedDateTime;
 
 
public Date getLastUpdatedDateTime() {
	return lastUpdatedDateTime;
}
public void setLastUpdatedDateTime(Date lastUpdatedDateTime) {
	this.lastUpdatedDateTime = lastUpdatedDateTime;
}
public int getShopid() {
	return shopid;
}
public void setShopid(int shopid) {
	this.shopid = shopid;
}
public String getShopOwner() {
	return shopOwner;
}
public void setShopOwner(String shopOwner) {
	this.shopOwner = shopOwner;
}
public String getShopType() {
	return shopType;
}
public void setShopType(String shopType) {
	this.shopType = shopType;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
public int getActive() {
	return active;
}
public void setActive(int active) {
	this.active = active;
}
@Override
public int hashCode() {
	return Objects.hash(active, address, city, pincode, shopOwner, shopType, shopid);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ShopDTO other = (ShopDTO) obj;
	return active == other.active && Objects.equals(address, other.address) && Objects.equals(city, other.city)
			&& Objects.equals(pincode, other.pincode) && Objects.equals(shopOwner, other.shopOwner)
			&& Objects.equals(shopType, other.shopType) && shopid == other.shopid;
}
 
 
 
}
