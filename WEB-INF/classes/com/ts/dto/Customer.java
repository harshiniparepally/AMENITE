package com.ts.dto;

public class Customer {
private int customerId;
private String customerName;
private long customerPhone;
private String customerEmail;
private String customerUserName;
private String customerPassword;
private String address;
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int custId) {
	this.customerId = custId;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String custName) {
	this.customerName = custName;
}

public long getPhone() {
	return customerPhone;
}
public void setPhone(long cPhone) {
	this.customerPhone = cPhone;
}
public String getEmail() {
	return customerEmail;
}

public void setEmail(String cEmail) {
	this.customerEmail = cEmail;
}

public String getUserName() {
	return customerUserName;
}
public void setUserName(String cUserName) {
	this.customerUserName = cUserName;
}
public String getPassword() {
	return customerPassword;
}
public void setPassword(String cPassword) {
	this.customerPassword = cPassword;
}

public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}


@Override
public String toString() {
	return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", Phone=" + customerPhone
			+ ", Email="+customerEmail+", userName=" + customerUserName + ", password=" + customerPassword + ", Address="+address+"]";
}
}