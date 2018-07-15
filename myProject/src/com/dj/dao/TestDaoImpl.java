package com.dj.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;



import com.dj.entity.AnswerSituation;
import com.dj.entity.Question;
import com.dj.entity.Test;
import com.dj.entity.TestPaper;
import com.dj.entity.TestRecord;
import com.dj.entity.TpRelationq;
import com.dj.entity.User;

public class TestDaoImpl extends HibernateDaoSupport implements TestDao {

	//根据uid查询用户
	public User ckUser(Integer uid) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where uid = ?", uid);
		if(list!= null && list.size() > 0){
			return list.get(0);
		}
		
		return null;
	}

	//查看考试信息
	public Test ckTest() {
		List<Test> list = (List<Test>) this.getHibernateTemplate().find("from Test t order by t.tdate desc", null);
		if(list!=null && list.size() > 0){
			return list.get(0);
		}
			
		
		return null;
	}

	//随机抽取试卷
	public TestPaper cqTestPaper() {
		List<TestPaper> list = (List<TestPaper>) this.getHibernateTemplate().find("from TestPaper", null);
		if(list!=null && list.size() > 0){
			//设置随机数
			Random rd = new Random();
			int rdnum = rd.nextInt(list.size());
			return list.get(rdnum);
		}
		return null;
	}

	//保存考试记录
	public void saveTestRecord(TestRecord tr) {
		this.getHibernateTemplate().save(tr);
		
	}

	//根据用户id查询考试记录
	public TestRecord ckTestRecord(Integer uid) {
		List<TestRecord> list =(List<TestRecord>) this.getHibernateTemplate().find("from TestRecord tr where tr.user.uid = ? order by tr.trdate desc", uid);
		if(list!=null && list.size()>0){
			return list.get(list.size()-1);
		}
		
		return null;
	}

	//根据试卷的ID获取试题与试卷的对应关系
	public List<TpRelationq> getTPQ(Integer tpid) {
		List<TpRelationq> list = (List<TpRelationq>) this.getHibernateTemplate().find("from TpRelationq tp where tp.testPaper.tpid=? order by tp.num asc",tpid);
		return list;
	}

	//根据试题与试卷对应关系中获取的试题id查找试题
	public Question ckQuestion(Integer qid) {
		List<Question> list =(List<Question>) this.getHibernateTemplate().find("from Question where qid = ?", qid);
		if(list!=null && list.size() > 0){
			
			return list.get(0);
		}
		return null;
	}

	//将试题与考试记录保存到答题情况表中
	public void saveAnswerSituation(AnswerSituation as) {
		this.getHibernateTemplate().save(as);
		
	}

	//根据试卷ID从试卷与试题关系表中找到选择题
	public List<TpRelationq> ckxzq(Integer tpid) {
		List<TpRelationq> xzqlist1 = (List<TpRelationq>) this.getHibernateTemplate().
				find("from TpRelationq tpq where tpq.testPaper.tpid = ? and tpq.question.questionType.qtid = ? order by tpq.num asc",tpid,1);
		List<TpRelationq> list = new ArrayList<TpRelationq>();
		//通过循环将选择题存入list集合中
		for(int i=0;i< xzqlist1.size();i++){
			//将查到的记录放入tpq对象中
			TpRelationq tpq = xzqlist1.get(i);
			Question q = new Question();
			//通过试卷与试题的关系找到与之对应的选择题
			List<Question> xzqlist2 = (List<Question>) this.getHibernateTemplate().
					find("from Question where qid = ?",xzqlist1.get(i).getQuestion().getQid());
			//将查到的选择题放入q
			q = xzqlist2.get(0);
			//在关系表中设置问题
			tpq.setQuestion(q);
			//将有关系的试题存入list中
			list.add(tpq);
			
		}
		
		
		return list;
	}

	//根据试卷ID从试卷与试题关系表中找到判断题
	public List<TpRelationq> ckpdq(Integer tpid) {
		List<TpRelationq> pdqlist1 = (List<TpRelationq>) this.getHibernateTemplate().
				find("from TpRelationq tpq where tpq.testPaper.tpid = ? and tpq.question.questionType.qtid = ? order by tpq.num asc", tpid,2);
		List<TpRelationq> list = new ArrayList<TpRelationq>();
		for(int i=0;i< pdqlist1.size();i++){
			//将查到的记录放入tpq对象中
			TpRelationq tpq = pdqlist1.get(i);
			Question q = new Question();
			//通过试卷与试题的关系找到与之对应的判断题
			List<Question> pdqlist2 = (List<Question>) this.getHibernateTemplate().
					find("from Question where qid = ?",pdqlist1.get(i).getQuestion().getQid());
			//将查到的判断题放入q
			q = pdqlist2.get(0);
			//在关系表中设置问题
			tpq.setQuestion(q);
			//将有关系的试题存入list中
			list.add(tpq);
		}
		
		
		return list;
	}

	//根据试卷ID从试卷与试题关系表中找到填空题
	public List<TpRelationq> cktkq(Integer tpid) {
		List<TpRelationq> tkqlist1 = (List<TpRelationq>) this.getHibernateTemplate().
				find("from TpRelationq tpq where tpq.testPaper.tpid = ? and tpq.question.questionType.qtid = ? order by tpq.num asc", tpid,3);
		List<TpRelationq> list = new ArrayList<TpRelationq>();
		for(int i=0;i< tkqlist1.size();i++){
			//将查到的记录放入tpq对象中
			TpRelationq tpq = tkqlist1.get(i);
			Question q = new Question();
			//通过试卷与试题的关系找到与之对应的填空题
			List<Question> tkqlist2 = (List<Question>) this.getHibernateTemplate().
					find("from Question where qid = ?",tkqlist1.get(i).getQuestion().getQid());
			//将查到的填空题放入q
			q = tkqlist2.get(0);
			//在关系表中设置问题
			tpq.setQuestion(q);
			//将有关系的试题存入list中
			list.add(tpq);
		}
		return list;
	}

	//根据试题范围找出合适的选择题
	public List<Question> ckxz(String qscope) {
		
			List<Question> listxz = (List<Question>) this.getHibernateTemplate()
					.find("from Question q where q.questionType.qtid = ? and q.qscope = ?",1,qscope);
			List<Question> list = new ArrayList<Question>();
			Question q = null;
			Random rand = new Random();		
			int[] r = new int[6];
			int randnum = 0 ;
			int i=0;
			while(i<6){
				randnum = rand.nextInt(listxz.size());
				boolean flag = true;
				for(int j=0;j<6;j++){
					if(randnum==r[j]){
						flag=false;
						break;
					}
				}
				if(flag){
					r[i]=randnum;
					q = listxz.get(randnum);
					list.add(q);
					i++;
				}
				
			}
			
			return list;
		
		
	}

	//根据试题范围找出合适的判断题
	public List<Question> ckpd(String qscope) {
		List<Question> listxz = (List<Question>) this.getHibernateTemplate()
				.find("from Question q where q.questionType.qtid = ? and q.qscope = ?",2,qscope);
		List<Question> list = new ArrayList<Question>();
		Question q = null;
		Random rand = new Random();		
		int[] r = new int[3];
		int randnum = 0 ;
		int i=0;
		while(i<3){
			randnum = rand.nextInt(listxz.size());
			boolean flag = true;
			for(int j=0;j<3;j++){
				if(randnum==r[j]){
					flag=false;
					break;
				}
			}
			if(flag){
				r[i]=randnum;
				q = listxz.get(randnum);
				list.add(q);
				i++;
			}
			
		}
		
		return list;
	}

	//随机
	public List<Question> cktk(String qscope) {
		List<Question> listtk = (List<Question>) this.getHibernateTemplate()
				.find("from Question q where q.questionType.qtid = ? and q.qscope = ?",3,qscope);
		Random rand = new Random();
		int randnum = rand.nextInt(listtk.size());
		List<Question> list =new ArrayList<Question>();
		Question q = listtk.get(randnum);
		list.add(q);
		
		return list;
	}

	//根据qid查找问题
	public Question findQ(Integer qid) {
		List<Question> list = (List<Question>) this.getHibernateTemplate().
		    find("from Question where qid = ?", qid);
		if(list!=null && list.size()>0){
			Question q = list.get(0);
			return q;
		}
		
		return null;
	}

}
