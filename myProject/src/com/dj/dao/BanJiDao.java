package com.dj.dao;

import java.util.List;

import com.dj.entity.BanJi;
import com.dj.entity.User;

public interface BanJiDao {

	List<BanJi> ckbj(Integer aid);

	List<User> ckBJUsers(Integer bjid);

	void deleteBJUser(Integer uid);

}
