package com.dj.action;

import com.dj.entity.QuestionType;
import com.dj.service.QuestionTypeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class QuestionTypeAction extends ActionSupport implements ModelDriven<QuestionType>{
	private QuestionTypeService questionTypeService;
	public void setQuestionTypeService(QuestionTypeService questionTypeService) {
		this.questionTypeService = questionTypeService;
	}

	//Ä£ÐÍÇý¶¯
	private QuestionType questionType=new QuestionType();
	public QuestionType getModel() {
		
		return questionType;
	}
	

}
