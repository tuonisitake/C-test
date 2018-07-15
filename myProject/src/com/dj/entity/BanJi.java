package com.dj.entity;

import java.util.HashSet;
import java.util.Set;

public class BanJi {
	
	private Integer bjid;//班级id
	private String bjname;//班级名字
	private Admin admin;
	private Set<User> users=new HashSet<User>();//该班级下的所有用户
	
	
	
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Integer getBjid() {
		return bjid;
	}
	public void setBjid(Integer bjid) {
		this.bjid = bjid;
	}
	public String getBjname() {
		return bjname;
	}
	public void setBjname(String bjname) {
		this.bjname = bjname;
	}
	

}
