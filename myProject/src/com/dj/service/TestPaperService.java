package com.dj.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dj.dao.TestPaperDao;
import com.dj.entity.Question;
import com.dj.entity.QuestionType;
import com.dj.entity.TestPaper;
import com.dj.entity.TpRelationq;
import com.dj.entity.User;

@Transactional
public class TestPaperService {
	private TestPaperDao testPaperDao;

	public void setTestPaperDao(TestPaperDao testPaperDao) {
		this.testPaperDao = testPaperDao;
	}
	


	public User ckUser(Integer uid) {
		// TODO Auto-generated method stub
		return testPaperDao.ckUser(uid);
	}



	public List<TestPaper> ckTestPaper(Integer aid) {
		
		return testPaperDao.ckTestPaper(aid);
	}



	public List<TpRelationq> ckTPQuestion(Integer tpid) {
		
		return testPaperDao.ckTPQuestion(tpid);
	}



	public void szTestPaper(TestPaper testPaper, Integer aid) {
		testPaperDao.szTestPaper(testPaper,aid);
		
	}



	public List<QuestionType> ckAllQT() {
		
		return testPaperDao.ckAllQT();
	}



	public TestPaper getTestPaper() {
		
		return testPaperDao.getTestPaper();
	}



	public List<Question> cqXZQ() {
		
		return testPaperDao.cqXZQ();
	}



	public List<Question> cqPDQ() {
		
		return testPaperDao.cqPDQ();
	}



	public List<Question> cqTKQ() {
		
		return testPaperDao.cqTKQ();
	}



	public void saveTestPaper(TestPaper testPaper) {
		testPaperDao.saveTestPaper(testPaper);
		
	}



	public void tjTestPaperSX(Integer tpid, Integer qid) {
		testPaperDao.tjTestPaperSX(tpid,qid);
		
	}



	public void deleteTestPaper(Integer tpid) {
		testPaperDao.deleteTestPaper(tpid);
		
	}




}
