package com.dj.entity;

public class TpRelationq {
	private Integer rid;	//试卷与试题对应关系表id
	private Integer num;	//试卷中试题的序号
	private Question question;//所属的试题
	private TestPaper testPaper;//所属的试卷
	
	
	public TestPaper getTestPaper() {
		return testPaper;
	}
	public void setTestPaper(TestPaper testPaper) {
		this.testPaper = testPaper;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}

}
