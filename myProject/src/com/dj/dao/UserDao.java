package com.dj.dao;

import java.util.List;

import com.dj.entity.AnswerSituation;
import com.dj.entity.BanJi;
import com.dj.entity.TestRecord;
import com.dj.entity.User;

public interface UserDao {

	User loginUser(User user);

	List<TestRecord> ckTestRecord(Integer uid);

	List<AnswerSituation> ckxzqas(Integer trid);

	List<AnswerSituation> ckpdqas(Integer trid);

	List<AnswerSituation> cktkqas(Integer trid);

	BanJi findmyBanJi(Integer uid);

	void updatePW(Integer uid, String newPW);

	List<User> ckAllUser(Integer aid);

	void deleteUser(Integer uid);

}
