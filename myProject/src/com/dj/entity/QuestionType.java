package com.dj.entity;

import java.util.HashSet;
import java.util.Set;

public class QuestionType {
	private Integer qtid;    //试题类型id
	private String qtname;	 //试题类型名称
	private Integer qtscore;	 //试题类型分数
	private Set<Question> questions=new HashSet<Question>();//该类型下的所有试题
	
	
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	public Integer getQtid() {
		return qtid;
	}
	public void setQtid(Integer qtid) {
		this.qtid = qtid;
	}
	public String getQtname() {
		return qtname;
	}
	public void setQtname(String qtname) {
		this.qtname = qtname;
	}
	public Integer getQtscore() {
		return qtscore;
	}
	public void setQtscore(Integer qtscore) {
		this.qtscore = qtscore;
	}
	

}
