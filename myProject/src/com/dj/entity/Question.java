package com.dj.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Question {
	private Integer qid;		//试题id
	private String qcontent;	//试题内容
	private String qaoption;		//选项a
	private String qboption;		//选项b
	private String qcoption;		//选项c
	private String qanswer;		//答案
	private String qanalysis;	//解析
	private String qkword;		//关键字
	private String qscope;		//试题范围
	
	private String qdifficulty; //试题难度
	private Date qdate;			//试题添加日期
	private QuestionType questionType;//试题所属类型
	private Admin admin;//出题管理员是谁
	private Set<AnswerSituation> answerSituation=new HashSet<AnswerSituation>();//该试题下的所有答题情况
	private Set<TpRelationq> tpRelationq=new HashSet<TpRelationq>();//该试题下的关系情况
	
    
	public String getQscope() {
		return qscope;
	}
	public void setQscope(String qscope) {
		this.qscope = qscope;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Set<TpRelationq> getTpRelationq() {
		return tpRelationq;
	}
	public void setTpRelationq(Set<TpRelationq> tpRelationq) {
		this.tpRelationq = tpRelationq;
	}
	public Set<AnswerSituation> getAnswerSituation() {
		return answerSituation;
	}
	public void setAnswerSituation(Set<AnswerSituation> answerSituation) {
		this.answerSituation = answerSituation;
	}
	public QuestionType getQuestionType() {
		return questionType;
	}
	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}
	public Integer getQid() {
		return qid;
	}
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	public String getQcontent() {
		return qcontent;
	}
	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}
	public String getQaoption() {
		return qaoption;
	}
	public void setQaoption(String qaoption) {
		this.qaoption = qaoption;
	}
	public String getQboption() {
		return qboption;
	}
	public void setQboption(String qboption) {
		this.qboption = qboption;
	}
	public String getQcoption() {
		return qcoption;
	}
	public void setQcoption(String qcoption) {
		this.qcoption = qcoption;
	}
	public String getQanswer() {
		return qanswer;
	}
	public void setQanswer(String qanswer) {
		this.qanswer = qanswer;
	}
	public String getQanalysis() {
		return qanalysis;
	}
	public void setQanalysis(String qanalysis) {
		this.qanalysis = qanalysis;
	}
	public String getQkword() {
		return qkword;
	}
	public void setQkword(String qkword) {
		this.qkword = qkword;
	}
	public String getQdifficulty() {
		return qdifficulty;
	}
	public void setQdifficulty(String qdifficulty) {
		this.qdifficulty = qdifficulty;
	}
	public Date getQdate() {
		return qdate;
	}
	public void setQdate(Date qdate) {
		this.qdate = qdate;
	}
	

}
