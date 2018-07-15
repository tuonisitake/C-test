package com.dj.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.dj.entity.TestRecord;

public class TestRecordDaoImpl extends HibernateDaoSupport implements
		TestRecordDao {

	//得到考试记录
	public TestRecord getTestRecord(Integer trid) {
		List<TestRecord> list = (List<TestRecord>) this.getHibernateTemplate().
				find("from TestRecord where trid = ?", trid);
		
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		
		return null;
	}

	//保存考试记录
	public void saveTestRecord(TestRecord tr) {
		this.getHibernateTemplate().save(tr);
		
	}
	
	
	

}
