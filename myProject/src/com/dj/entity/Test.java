package com.dj.entity;

import java.util.Date;

public class Test {
	private Integer tid;  //考试id
	private String tname;	//考试名称
	private Date tdate;		//考试时间
	private TestPaper testPaper;//所对应的试卷
	
	public TestPaper getTestPaper() {
		return testPaper;
	}
	public void setTestPaper(TestPaper testPaper) {
		this.testPaper = testPaper;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Date getTdate() {
		return tdate;
	}
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
	

}
