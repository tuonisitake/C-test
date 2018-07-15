package com.dj.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TestRecord {
	private Integer trid;	//考试记录id
	private String trname;	//考试名称
	private Date trdate;		//考试日期
	private Date stime;		//开始答题时间
	private Date etime;		//交卷时间
	private Integer trscore;	//考试成绩
	private TestPaper testPaper;//所属的试卷
	private User user;//所属的用户
	private Set<AnswerSituation> answerSituation=new HashSet<AnswerSituation>();//该考试记录下的答题情况
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public TestPaper getTestPaper() {
		return testPaper;
	}
	public void setTestPaper(TestPaper testPaper) {
		this.testPaper = testPaper;
	}
	public Set<AnswerSituation> getAnswerSituation() {
		return answerSituation;
	}
	public void setAnswerSituation(Set<AnswerSituation> answerSituation) {
		this.answerSituation = answerSituation;
	}
	public Integer getTrid() {
		return trid;
	}
	public void setTrid(Integer trid) {
		this.trid = trid;
	}
	public String getTrname() {
		return trname;
	}
	public void setTrname(String trname) {
		this.trname = trname;
	}
	public Date getTrdate() {
		return trdate;
	}
	public void setTrdate(Date trdate) {
		this.trdate = trdate;
	}
	public Date getStime() {
		return stime;
	}
	public void setStime(Date stime) {
		this.stime = stime;
	}
	public Date getEtime() {
		return etime;
	}
	public void setEtime(Date etime) {
		this.etime = etime;
	}
	public Integer getTrscore() {
		return trscore;
	}
	public void setTrscore(Integer trscore) {
		this.trscore = trscore;
	}


}
