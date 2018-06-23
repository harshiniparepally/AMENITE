package com.ts.dto;

public class Professional {
	private int proId;
	private String proName;
	private long proPhone;
	private String proEmail;
	private String proUserName;
	private String proPassword;
	private int sId;
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}

	public long getProPhone() {
		return proPhone;
	}
	public void setProPhone(long pPhone) {
		this.proPhone = pPhone;
	}
	public String getProEmail() {
		return proEmail;
	}

	public void setProEmail(String pEmail) {
		this.proEmail = pEmail;
	}

	public String getProUserName() {
		return proUserName;
	}
	public void setProUserName(String pUserName) {
		this.proUserName = pUserName;
	}
	public String getProPassword() {
		return proPassword;
	}
	public void setProPassword(String pPassword) {
		this.proPassword = pPassword;
	}
	public int getProSId() {
		return sId;
	}
	public void setProSId(int sId) {
		this.sId = sId;
	}
	@Override
	public String toString() {
		return "Professional [ProfessionalId=" + proId + ", ProfessinalName=" + proName + ", ProfessionalPhone=" + proPhone
				+ ", ProfessionalEmail="+proEmail+", ProfessionalUserName=" + proUserName + ", ProfessionalPassword=" + proPassword + ", ProfessionalService="+ sId+"]";
	}
}
