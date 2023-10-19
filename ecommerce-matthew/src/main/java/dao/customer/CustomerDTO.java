package dao.customer;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
public class CustomerDTO implements Serializable, Comparable<CustomerDTO>{
	private int customerid;
	private String customername;
	private String password;
	private String mobileno;
	private String emailId;
	private Date loginDate; 
	 
	
	private int activeFlag;
	private int alreadyLoggedIn;
	
	
	@Override
	public String toString() {
		return "CustomerDTO [customerid=" + customerid + ", customername=" + customername + ", password=" + password
				+ ", mobileno=" + mobileno + ", emailId=" + emailId + ", loginDate=" + loginDate + ", activeFlag="
				+ activeFlag + ", alreadyLoggedIn=" + alreadyLoggedIn + "]";
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(activeFlag, alreadyLoggedIn, customerid, customername, emailId, loginDate, mobileno,
				password);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		return activeFlag == other.activeFlag && alreadyLoggedIn == other.alreadyLoggedIn
				&& customerid == other.customerid && Objects.equals(customername, other.customername)
				&& Objects.equals(emailId, other.emailId) && Objects.equals(loginDate, other.loginDate)
				&& Objects.equals(mobileno, other.mobileno) && Objects.equals(password, other.password);
	}


	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public int getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}
	public int getAlreadyLoggedIn() {
		return alreadyLoggedIn;
	}
	public void setAlreadyLoggedIn(int alreadyLoggedIn) {
		this.alreadyLoggedIn = alreadyLoggedIn;
	}


	@Override
	public int compareTo(CustomerDTO o) {
		// TODO Auto-generated method stub
		return o.customerid;
	}

	
	
	
}
