package com.dj.entity;

import java.util.HashSet;
import java.util.Set;

public class Admin {
	private Integer aid;
	private String adminname;
	private String password;
	private Set<BanJi> bjs=new HashSet<BanJi>();
	private Set<Question> questions=new HashSet<Question>();//该管理员下的所有试题
	
	
	
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	public Set<BanJi> getBjs() {
		return bjs;
	}
	public void setBjs(Set<BanJi> bjs) {
		this.bjs = bjs;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
