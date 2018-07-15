package com.dj.entity;

public class AnswerSituation {
	private Integer anid;//答题情况id
	private Integer situation;//答题情况
	private Question question;//该答题情况所属的试题类型
	private TestRecord testRecord;//所属考试记录
	
	
	
	
	
	public TestRecord getTestRecord() {
		return testRecord;
	}
	public void setTestRecord(TestRecord testRecord) {
		this.testRecord = testRecord;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Integer getAnid() {
		return anid;
	}
	public void setAnid(Integer anid) {
		this.anid = anid;
	}
	public Integer getSituation() {
		return situation;
	}
	public void setSituation(Integer situation) {
		this.situation = situation;
	}

}
