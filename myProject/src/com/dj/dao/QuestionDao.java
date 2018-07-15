package com.dj.dao;

import java.util.List;

import com.dj.entity.Admin;
import com.dj.entity.Question;
import com.dj.entity.QuestionType;

public interface QuestionDao {

	Question ckQuestionDetail(Integer qid);

	List<QuestionType> ckQuestionType();

	Question findQuestion(Integer qid);

	int findTotalCount(Question question, int qtid);

	List<Question> findQuestionList(Question question, int qtid, int begin,
			int limit);

	void savexzq(Question question, int qtid, int aid);

	void savepdq(Question question, int qtid, int aid);

	void deleteQ(Integer qid);

	QuestionType findQT(int qtid);

	Admin findA(int aid);

	void saveq(Question q);



}
