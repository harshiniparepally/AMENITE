package com.ts.dto;
import java.lang.*;
import java.io.*;

public class SubServices {
	private int ssId;
	private String ssName;
	private int price;
	private int sId;
	private String description;
	private String photo;
	public int getSubServiceId() {
	
		return ssId;
	}
	public void setSubServiceId(int ssId) {
		this.ssId = ssId;
	}
	public String getSubServiceName() {
		return ssName;
	}
	public void setSubServiceName(String ssName) {
		this.ssName = ssName;
	}
	public int getSubServicePrice() {
		return price;
	}
	public void setSubServicePrice(int price) {
		this.price = price;
	}
	public int getServiceId() {
		return sId;
	}
	public void setServiceId(int sId) {
		this.sId = sId;
	}
	public String getDescription(){
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Override
	public String toString() {
		return "SubService [ssId=" + ssId + ", SubServiceName=" + ssName + ", Price=" + price +", Service Id ="+sId+", Description ="+description+", Photo ="+photo+"]";
	}
}
