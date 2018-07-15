package com.dj.service;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.dj.dao.AnswerSituationDao;
import com.dj.entity.AnswerSituation;
import com.dj.entity.Question;
import com.dj.entity.TestRecord;

@Transactional
public class AnswerSituationService {
	private AnswerSituationDao answerSituationDao;
	public void setAnswerSituationDao(AnswerSituationDao answerSituationDao) {
		this.answerSituationDao = answerSituationDao;
	}
	public void saveAS(Integer trid, Integer qid, String qas) {
		AnswerSituation a = answerSituationDao.hqAnswerState(trid,qid);
		Question q = answerSituationDao.hqQuestion(qid);
		TestRecord tr =answerSituationDao.hqTestRecord(trid);
		if(qas!= null && qas.equals(q.getQanswer())){	
			a.setSituation(1);
		}else{
			a.setSituation(2);
		}
		
		
		a.setQuestion(q);
		a.setTestRecord(tr);
		answerSituationDao.saveAS(a);
		
	}
	public void upEndTime(Integer trid) {
		TestRecord t = answerSituationDao.findTestRecord(trid);
		t.setEtime(new Date());
		answerSituationDao.saveT(t);
	}
	

}
