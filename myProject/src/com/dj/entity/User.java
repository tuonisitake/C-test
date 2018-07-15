package com.dj.entity;

import java.util.HashSet;
import java.util.Set;

public class User {
	private Integer uid;
	private String username;
	private String password;
	private BanJi banJi;
	private Set<TestRecord> testRecord=new HashSet<TestRecord>();//该用户下的所有考试记录
	
	
	

	public BanJi getBanJi() {
		return banJi;
	}
	public void setBanJi(BanJi banJi) {
		this.banJi = banJi;
	}
	public Set<TestRecord> getTestRecord() {
		return testRecord;
	}
	public void setTestRecord(Set<TestRecord> testRecord) {
		this.testRecord = testRecord;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
