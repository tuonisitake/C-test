package com.dj.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;



import com.dj.entity.Admin;
import com.dj.entity.Question;
import com.dj.entity.QuestionType;


public class QuestionDaoImpl extends HibernateDaoSupport implements QuestionDao {

	//查看相应试题
	public Question ckQuestionDetail(Integer qid) {
		
		List<Question> listq = (List<Question>) this.getHibernateTemplate().
				find("from Question where qid = ?", qid);
		if(listq!=null && listq.size()>0){
			Question q =listq.get(0);
			List<QuestionType> listqt = (List<QuestionType>) this.getHibernateTemplate().
					find("from QuestionType where qtid = ?", listq.get(0).getQuestionType().getQtid());
			if(listqt!=null && listqt.size()>0){
				q.setQuestionType(listqt.get(0));
				return q;
			}
			
		}
		
		
		return null;
	}

	//查询试题类型
	public List<QuestionType> ckQuestionType() {
		
		List<QuestionType> listqt = (List<QuestionType>) this.getHibernateTemplate().
				find("from QuestionType", null);
		if(listqt!=null && listqt.size()>0){
			return listqt;
		}
		
		return null;
	}

	//查找试题
	public Question findQuestion(Integer qid) {
		
		List<Question> list = (List<Question>) this.getHibernateTemplate().
		            find("from Question where qid = ?", qid);
		if(list != null && list.size()>0){
		   return list.get(0);
		}
		return null;
	}

	//找到符合条件的试题总数,离线对象
	public int findTotalCount(Question question, int qtid) {
		/*
		List<Long> list =(List<Long>) this.getHibernateTemplate().
				find("select count(*) from Question q where q.questionType.qtid= ? and q.qscope = ? and q.qdifficulty = ?", qtid,question.getQscope(),question.getQdifficulty());*/
		DetachedCriteria criteria = DetachedCriteria.forClass(Question.class);
		//判断条件
		if(qtid == 1 || qtid == 2 || qtid == 3){
			criteria.add(Restrictions.eq("questionType.qtid", qtid));
			
		}
		if(question.getQscope()!=null && !"全部".equals(question.getQscope())){
			criteria.add(Restrictions.eq("qscope", question.getQscope()));
			
		}
		if(question.getQdifficulty()!=null && !"全部".equals(question.getQdifficulty())){
			criteria.add(Restrictions.eq("qdifficulty", question.getQdifficulty()));
			
		}
		if(question.getQcontent()!=null && !"".equals(question.getQcontent())){
			criteria.add(Restrictions.like("qcontent", "%"+question.getQcontent()+"%"));
			
		}
		List<Question> list = (List<Question>) this.getHibernateTemplate()
				.findByCriteria(criteria);
		
		
		return list.size();
	}

	//根据条件获取试题集合,离线对象
	public List<Question> findQuestionList(Question question, int qtid,
			int begin, int limit) {
		
		DetachedCriteria criteria =DetachedCriteria.forClass(Question.class);
		//判断条件
		if(qtid == 1 || qtid == 2 || qtid == 3){
			criteria.add(Restrictions.eq("questionType.qtid", qtid));
					
		}
		if(question.getQscope()!=null && !"全部".equals(question.getQscope())){
			criteria.add(Restrictions.eq("qscope", question.getQscope()));
					
		}
		if(question.getQdifficulty()!=null && !"全部".equals(question.getQdifficulty())){
			criteria.add(Restrictions.eq("qdifficulty", question.getQdifficulty()));
					
		}
		if(question.getQcontent()!=null && !"".equals(question.getQcontent())){
			criteria.add(Restrictions.like("qcontent","%"+question.getQcontent()+"%"));
			
		}
		List<Question> list =(List<Question>) this.getHibernateTemplate()
				.findByCriteria(criteria, begin, limit);
		
		
		
		return list;
		
		
	}

	//添加选择题
	public void savexzq(Question question, int qtid, int aid) {
		List<QuestionType> listqt =(List<QuestionType>) this.getHibernateTemplate().
				find("from QuestionType where qtid = ?", qtid);
		List<Admin> lista = (List<Admin>) this.getHibernateTemplate().
				find("from Admin where aid = ?", aid);
		if(listqt!= null && listqt.size()>0){
			question.setQuestionType(listqt.get(0));
		}
		if(lista!=null && lista.size()>0){
			
			question.setAdmin(lista.get(0));
			
		}
		this.getHibernateTemplate().save(question);
		
	}

	//添加判断题
	public void savepdq(Question question, int qtid, int aid) {
		List<QuestionType> listqt =(List<QuestionType>) this.getHibernateTemplate().
				find("from QuestionType where qtid = ?", qtid);
		List<Admin> lista = (List<Admin>) this.getHibernateTemplate().
				find("from Admin where aid = ?", aid);
		if(listqt!= null && listqt.size()>0){
			question.setQuestionType(listqt.get(0));
		}
		if(lista!=null && lista.size()>0){
			
			question.setAdmin(lista.get(0));
			
		}
		this.getHibernateTemplate().save(question);
		
		
	}

	//删除试题
	public void deleteQ(Integer qid) {
		List<Question> list =(List<Question>) this.getHibernateTemplate().
				find("from Question where qid = ?", qid);
		if(list!=null && list.size()>0){
			this.getHibernateTemplate().delete(list.get(0));
			
		}
		
	}

	
	public QuestionType findQT(int qtid) {
		List<QuestionType> listqt =(List<QuestionType>) this.getHibernateTemplate().
				find("from QuestionType where qtid = ?", qtid);
		
		return listqt.get(0);
	}

	
	public Admin findA(int aid) {
		List<Admin> lista = (List<Admin>) this.getHibernateTemplate().
				find("from Admin where aid = ?", aid);
		return lista.get(0);
	}

	
	public void saveq(Question q) {
		this.getHibernateTemplate().save(q);
		
	}

	


}
