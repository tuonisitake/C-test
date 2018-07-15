package com.dj.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.dj.entity.BanJi;
import com.dj.entity.User;

public class BanJiDaoImpl extends HibernateDaoSupport implements BanJiDao {

	//查看班级
	public List<BanJi> ckbj(Integer aid) {
		List<BanJi> list = (List<BanJi>) this.getHibernateTemplate().
				find("from BanJi where aid = ?", aid);
		return list;
	}
	
	

	//查看班级人员
	public List<User> ckBJUsers(Integer bjid) {
		
		List<User> list = (List<User>) this.getHibernateTemplate().
				find("from User u where u.banJi.bjid = ? order by u.uid desc", bjid);
		if(list!=null && list.size()>0){
			
			return list;
		}
		
		return null;
	}

	//删除班级成员
	public void deleteBJUser(Integer uid) {
		List<User> listu = (List<User>) this.getHibernateTemplate()
				.find("from User where uid = ?", uid);
		if(listu!=null && listu.size()>0){
			this.getHibernateTemplate().delete(listu.get(0));
			
		}
				
		
	}

}
