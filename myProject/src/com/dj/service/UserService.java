package com.dj.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dj.dao.UserDao;
import com.dj.entity.AnswerSituation;
import com.dj.entity.BanJi;
import com.dj.entity.TestRecord;
import com.dj.entity.User;


@Transactional
public class UserService {
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	 
	
	public User login(User user) {
		
		return userDao.loginUser(user);
	}


	public List<TestRecord> ckTestRecord(Integer uid) {
		
		return userDao.ckTestRecord(uid);
	}


	public List<AnswerSituation> ckxzqas(Integer trid) {
		
		return userDao.ckxzqas(trid);
	}


	public List<AnswerSituation> ckpdqas(Integer trid) {
		
		return userDao.ckpdqas(trid);
	}


	public List<AnswerSituation> cktkqas(Integer trid) {
		
		return userDao.cktkqas(trid);
	}


	public BanJi findmyBanji(Integer uid) {
		
		return userDao.findmyBanJi(uid);
	}


	public void updatePW(Integer uid, String newPW) {
		userDao.updatePW(uid,newPW);
		
	}


	public List<User> ckAllUser(Integer aid) {
		
		return userDao.ckAllUser(aid);
	}


	public void deleteUser(Integer uid) {
		userDao.deleteUser(uid);
		
	}





    //

}
