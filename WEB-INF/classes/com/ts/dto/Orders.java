package com.ts.dto;

import java.util.Date;

public class Orders {
	private int oId;
	private String address;
	private Date oDate;
	private int oTime;
	
	public int getOId() {
		return oId;
	}
	public void setOId(int oId) {
		this.oId = oId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getODate() {
		return oDate;
	}
	public void setODate(Date oDate) {
		this.oDate = oDate;
	}
	public int getOTime() {
		return oTime;
	}
	public void setOTime(int oTime) {
		this.oTime = oTime;
	}
}
