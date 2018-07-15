package com.dj.dao;

import java.util.List;

import com.dj.entity.Admin;
import com.dj.entity.AnswerSituation;
import com.dj.entity.TestRecord;

public interface AdminDao {

	Admin loginAdmini(Admin admin);

	void updatePWSX(Integer aid, String newPW);

	void deleteTestRecord(Integer trid);

	void deleteAnswerSituation(Integer trid);

	List<TestRecord> ckTestRecord(Integer uid);

	List<AnswerSituation> ckxzqas(Integer trid);

	List<AnswerSituation> ckpdqas(Integer trid);

	List<AnswerSituation> cktkqas(Integer trid);

}
