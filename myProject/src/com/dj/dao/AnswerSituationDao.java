package com.dj.dao;

import com.dj.entity.AnswerSituation;
import com.dj.entity.Question;
import com.dj.entity.TestRecord;


public interface AnswerSituationDao {

	

	void saveAS(AnswerSituation a);

	AnswerSituation hqAnswerState(Integer trid, Integer qid);

	Question hqQuestion(Integer qid);

	TestRecord hqTestRecord(Integer trid);

	TestRecord findTestRecord(Integer trid);

	void saveT(TestRecord t);

	



}
