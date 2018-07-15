package com.dj.dao;

import java.util.List;

import com.dj.entity.Question;
import com.dj.entity.QuestionType;
import com.dj.entity.TestPaper;
import com.dj.entity.TpRelationq;
import com.dj.entity.User;

public interface TestPaperDao {

	User ckUser(Integer uid);

	List<TestPaper> ckTestPaper(Integer aid);

	List<TpRelationq> ckTPQuestion(Integer tpid);

	void szTestPaper(TestPaper testPaper, Integer aid);

	List<QuestionType> ckAllQT();

	TestPaper getTestPaper();

	List<Question> cqXZQ();

	List<Question> cqPDQ();

	List<Question> cqTKQ();

	void saveTestPaper(TestPaper testPaper);

	void tjTestPaperSX(Integer tpid, Integer qid);

	void deleteTestPaper(Integer tpid);

	

}
