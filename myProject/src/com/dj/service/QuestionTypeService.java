package com.dj.service;

import org.springframework.transaction.annotation.Transactional;

import com.dj.dao.QuestionTypeDao;

@Transactional
public class QuestionTypeService {
	private QuestionTypeDao questionTypeDao;

	public void setQuestionTypeDao(QuestionTypeDao questionTypeDao) {
		this.questionTypeDao = questionTypeDao;
	}
	

}
