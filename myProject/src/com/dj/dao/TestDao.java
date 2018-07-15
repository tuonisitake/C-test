package com.dj.dao;

import java.util.List;

import com.dj.entity.AnswerSituation;
import com.dj.entity.Question;
import com.dj.entity.Test;
import com.dj.entity.TestPaper;
import com.dj.entity.TestRecord;
import com.dj.entity.TpRelationq;
import com.dj.entity.User;

public interface TestDao {

	User ckUser(Integer uid);

	Test ckTest();

	TestPaper cqTestPaper();

	void saveTestRecord(TestRecord tr);

	TestRecord ckTestRecord(Integer uid);

	List<TpRelationq> getTPQ(Integer tpid);

	Question ckQuestion(Integer qid);

	void saveAnswerSituation(AnswerSituation as);

	List<TpRelationq> ckxzq(Integer tpid);

	List<TpRelationq> ckpdq(Integer tpid);

	List<TpRelationq> cktkq(Integer tpid);

	List<Question> ckxz(String qscope);

	List<Question> ckpd(String qscope);

	List<Question> cktk(String qscope);

	Question findQ(Integer qid);

}
