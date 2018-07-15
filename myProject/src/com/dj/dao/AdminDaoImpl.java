package com.dj.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.dj.entity.Admin;
import com.dj.entity.AnswerSituation;
import com.dj.entity.Question;
import com.dj.entity.TestRecord;
import com.dj.entity.User;

public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {

    //Admin的登录
	public Admin loginAdmini(Admin admin) {
		List<Admin> list = (List<Admin>) this.getHibernateTemplate().
	    	     find("from Admin where adminname=? and password=?", admin.getAdminname(),admin.getPassword());
			
	    	//如果查询之后，没有结果，list里面没有值，根据get（下标）获取不到值，出现下标越界异常
	    	if(list != null && list.size()!=0){
	    		Admin u = list.get(0);
	    		return u;
	    	}
		return null;
	}

	//修改密码
	public void updatePWSX(Integer aid, String newPW) {
		Admin admin = null;
		List<Admin> list =(List<Admin>) this.getHibernateTemplate()
				.find("from Admin where aid =?", aid);
		if(list!=null && list.size()>0){
			admin = list.get(0);
		}
		admin.setPassword(newPW);
		this.getHibernateTemplate().save(admin);
		
		
	}

	//删除考试记录
	public void deleteTestRecord(Integer trid) {
		List<TestRecord> list = (List<TestRecord>) this.getHibernateTemplate()
				.find("from TestRecord where trid = ?", trid);
		if(list!=null && list.size()>0){
			this.getHibernateTemplate().delete(list.get(0));
		}
		
	}

	//删除该考试记录下的答题情况
	public void deleteAnswerSituation(Integer trid) {
		List<AnswerSituation> list =(List<AnswerSituation>) this.getHibernateTemplate()
				.find("from AnswerSituation a where a.testRecord.trid = ?", trid);
		if(list!=null && list.size()>0){
			for(int i=0;i<list.size();i++){
				this.getHibernateTemplate().delete(list.get(i));
				
			}
			
			
		}
		
	}

	//查看考试记录
	public List<TestRecord> ckTestRecord(Integer uid) {
		Integer sum=null;
		Integer xzq=null;
		Integer pdq=null;
		Integer tkq=null;
		//listtr中存放该用户的考试记录
		List<TestRecord> listtr=(List<TestRecord>) this.getHibernateTemplate().
				find("from TestRecord tr where tr.user.uid = ? order by tr.trid desc ", uid);

		List<TestRecord> list = new ArrayList<TestRecord>();
		
		//将每条记录中各个题目的分数进行累加
		for(int i=0;i < listtr.size();i++){
		TestRecord tr =listtr.get(i);
		String hql = "select count(*) from AnswerSituation ast where ast.testRecord.trid = ? and ast.situation = ? and ast.question.questionType.qtid = ?";
		List<Long> xzlist = (List<Long>) this.getHibernateTemplate().
				find(hql, listtr.get(i).getTrid(),1,1);
		if(xzlist!=null && xzlist.size()>0){
			
			xzq = xzlist.get(0).intValue()*10;
		}
		List<Long> pdlist = (List<Long>) this.getHibernateTemplate().
				find(hql, listtr.get(i).getTrid(),1,2);
		if(pdlist!=null && pdlist.size()>0){
			
			pdq = pdlist.get(0).intValue()*5;
		}
		List<Long> tklist = (List<Long>) this.getHibernateTemplate().
				find(hql, listtr.get(i).getTrid(),1,3);
		if(tklist!=null && tklist.size()>0){
			
			tkq = tklist.get(0).intValue()*25;
		}
		sum=xzq+pdq+tkq;
		tr.setTrscore(sum);
		this.getHibernateTemplate().save(tr);
		list.add(tr);
	}
	
	
	
	return list;
	}

	
	public List<AnswerSituation> ckxzqas(Integer trid) {
		
		//根据考试记录id找到与之相关的选择题
				List<AnswerSituation> listas = (List<AnswerSituation>) this.getHibernateTemplate().
						find("from AnswerSituation ast where ast.testRecord.trid = ? and ast.question.questionType.qtid = ? order by ast.anid asc", trid,1);
				List<AnswerSituation> list =new ArrayList<AnswerSituation>();
				//循环保存Question
				for(int i=0;i<listas.size();i++){
					AnswerSituation ast = listas.get(i);
					List<Question> lq = (List<Question>) this.getHibernateTemplate().
							find("from Question where qid = ?", listas.get(i).getQuestion().getQid());
					if(lq!=null && lq.size()>0){
						
						ast.setQuestion(lq.get(0));
						
					}
					list.add(ast);
				}
				
				return list;
	}
	//查看判断题答题情况
		public List<AnswerSituation> ckpdqas(Integer trid) {
			
			//根据考试记录id找到与之相关的判断题
					List<AnswerSituation> listas = (List<AnswerSituation>) this.getHibernateTemplate().
							find("from AnswerSituation ast where ast.testRecord.trid = ? and ast.question.questionType.qtid = ? order by ast.anid asc", trid,2);
					List<AnswerSituation> list =new ArrayList<AnswerSituation>();
					//循环保存Question
					for(int i=0;i<listas.size();i++){
						AnswerSituation ast = listas.get(i);
						List<Question> lq = (List<Question>) this.getHibernateTemplate().
								find("from Question where qid = ?", listas.get(i).getQuestion().getQid());
						if(lq!=null && lq.size()>0){
							
							ast.setQuestion(lq.get(0));
							
						}
						list.add(ast);
					}
					
					return list;
		}

		//查看填空题答题情况
		public List<AnswerSituation> cktkqas(Integer trid) {
			//根据考试记录id找到与之相关的填空题
			List<AnswerSituation> listas = (List<AnswerSituation>) this.getHibernateTemplate().
					find("from AnswerSituation ast where ast.testRecord.trid = ? and ast.question.questionType.qtid = ? order by ast.anid asc", trid,3);
			List<AnswerSituation> list =new ArrayList<AnswerSituation>();
			//循环保存Question
			for(int i=0;i<listas.size();i++){
				AnswerSituation ast = listas.get(i);
				List<Question> lq = (List<Question>) this.getHibernateTemplate().
						find("from Question where qid = ?", listas.get(i).getQuestion().getQid());
				if(lq!=null && lq.size()>0){
					
					ast.setQuestion(lq.get(0));
					
				}
				list.add(ast);
			}
			
			return list;
		}

}
