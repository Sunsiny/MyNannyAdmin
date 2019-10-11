package com.qiamfeng.nanny.entity;

public class User {
	private int user_id;
	private String username;
	private String realname;
	private String address;
	private String tel;
	
	
	
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int user_id, String username, String realname, String address, String tel) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.realname = realname;
		this.address = address;
		this.tel = tel;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", realname=" + realname + ", address=" + address
				+ ", tel=" + tel + "]";
	}
	
	
	

}
