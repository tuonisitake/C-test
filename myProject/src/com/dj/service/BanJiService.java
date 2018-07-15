package com.dj.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import com.dj.dao.BanJiDao;
import com.dj.entity.BanJi;
import com.dj.entity.User;

@Transactional
public class BanJiService {
	private BanJiDao banJiDao;

	public void setBanJiDao(BanJiDao banJiDao) {
		this.banJiDao = banJiDao;
	}

	public List<BanJi> ckbj(Integer aid) {
		List<BanJi> list = banJiDao.ckbj(aid);
		
		return list;
	}

	public List<User> ckBJUsers(Integer bjid) {
		
		return banJiDao.ckBJUsers(bjid);
	}

	public void deleteBJUser(Integer uid) {
		banJiDao.deleteBJUser(uid);
		
	}



}
