package com.train.bean;

public class Forget {
	private String uname;
	private String password;
	private String email;
	private String phonenumber;
	
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Forget [uname=" + uname + ", password=" + password + ", email=" + email + ", phonenumber=" + phonenumber
				+ "]";
	}
	
}
