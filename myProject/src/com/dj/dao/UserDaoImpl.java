package com.dj.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.dj.entity.Admin;
import com.dj.entity.AnswerSituation;
import com.dj.entity.BanJi;
import com.dj.entity.Question;
import com.dj.entity.TestRecord;
import com.dj.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	
	
	
//	private HibernateTemplate hibernateTemplate;
//	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
//		this.hibernateTemplate = hibernateTemplate;
//	}
	
	
	//登录
    public User loginUser(User user) {
    	
    	List<User> list = (List<User>) this.getHibernateTemplate().
    	     find("from User where username=? and password=?", user.getUsername(),user.getPassword());
		
    	//如果查询之后，没有结果，list里面没有值，根据get（下标）获取不到值，出现下标越界异常
    	if(list != null && list.size()!=0){
    		User u = list.get(0);
    		return u;
    	}
    	
    	
		
		return null;
	}

	//根据uid查询考试记录
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

	//查看选择题答题情况
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

	//查询班级
	public BanJi findmyBanJi(Integer uid) {
		BanJi banji =null;
		Admin admin =null;
		//通过uid找到所属班级
		List<User> listu=(List<User>) this.getHibernateTemplate().
				find("from User where uid = ?", uid);
		if(listu!= null && listu.size()>0){
			List<BanJi> listbj = (List<BanJi>) this.getHibernateTemplate().
					find("from BanJi where bjid = ?", listu.get(0).getBanJi().getBjid());
			if(listbj!=null && listbj.size()>0){
				banji = listbj.get(0);
				//班级管理员
				List<Admin> lista = (List<Admin>) this.getHibernateTemplate().
						find("from Admin where aid = ?", listbj.get(0).getAdmin().getAid());
				if(lista!= null && lista.size()>0){
					banji.setAdmin(lista.get(0));
					return banji;
					
					
				}
						
				
				
			}
			
			
			
		}
		
		
		
		return null;
	}

	//修改密码
	public void updatePW(Integer uid, String newPW) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where uid = ?", uid);
		User u = null;
		if(list!= null && list.size()>0){
			
			u = list.get(0);
			
		}
		u.setPassword(newPW);
		this.getHibernateTemplate().save(u);
		
	}

	//查看所有人员
	public List<User> ckAllUser(Integer aid) {
		List<User> list = (List<User>) this.getHibernateTemplate()
				.find("from User u where u.banJi.admin.aid = ?", aid);
        List<User> listu =new ArrayList<User>();
        for(int i=0;i<list.size();i++){
        	User u = list.get(i);
        	List<BanJi> listbj =(List<BanJi>) this.getHibernateTemplate()
        			.find("from BanJi where bjid = ?", list.get(i).getBanJi().getBjid());
        	if(listbj!= null && listbj.size()>0){
        		
        		u.setBanJi(listbj.get(0));
        	}
        	listu.add(u);
        	
        	
        }

		
		return listu;
	}

	//删除用户
	public void deleteUser(Integer uid) {
		List<User> list =(List<User>) this.getHibernateTemplate()
				.find("from User where uid = ?", uid);
		if(list!=null && list.size()>0){
			this.getHibernateTemplate().delete(list.get(0));
			
		}
		
	}

}
