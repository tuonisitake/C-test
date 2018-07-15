package com.dj.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dj.dao.AdminDao;
import com.dj.entity.Admin;
import com.dj.entity.AnswerSituation;
import com.dj.entity.TestRecord;

@Transactional
public class AdminService {
	
	private AdminDao adminDao;
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}


	public Admin login(Admin admin) {
		return adminDao.loginAdmini(admin);
	
	}


	public void updatePWSX(Integer aid, String newPW) {
		adminDao.updatePWSX(aid,newPW);
		
	}


	public void deleteTestRecord(Integer trid) {
		adminDao.deleteTestRecord(trid);
		adminDao.deleteAnswerSituation(trid);
		
	}


	public List<TestRecord> ckTestRecord(Integer uid) {
		
		return adminDao.ckTestRecord(uid);
	}


	public List<AnswerSituation> ckxzqas(Integer trid) {
		
		return adminDao.ckxzqas(trid);
	}


	public List<AnswerSituation> ckpdqas(Integer trid) {
		
		return adminDao.ckpdqas(trid);
	}


	public List<AnswerSituation> cktkqas(Integer trid) {
		
		return adminDao.cktkqas(trid);
	}

}
