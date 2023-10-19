package dao.order;

import java.sql.Date;
import java.util.Objects;

public class OrderDTO {
private int orderid;
private int shoppingcartid;
private Date lastupdatedDate;
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public int getShoppingcartid() {
	return shoppingcartid;
}
public void setShoppingcartid(int shoppingcartid) {
	this.shoppingcartid = shoppingcartid;
}
public Date getLastupdatedDate() {
	return lastupdatedDate;
}
public void setLastupdatedDate(Date lastupdatedDate) {
	this.lastupdatedDate = lastupdatedDate;
}
@Override
public String toString() {
	return "OrderServiceDTO [orderid=" + orderid + ", shoppingcartid=" + shoppingcartid + ", lastupdatedDate="
			+ lastupdatedDate + "]";
}
@Override
public int hashCode() {
	return Objects.hash(lastupdatedDate, orderid, shoppingcartid);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	OrderDTO other = (OrderDTO) obj;
	return Objects.equals(lastupdatedDate, other.lastupdatedDate) && orderid == other.orderid
			&& shoppingcartid == other.shoppingcartid;
}



}
