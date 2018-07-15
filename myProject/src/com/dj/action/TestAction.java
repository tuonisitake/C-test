package com.dj.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.dj.entity.Question;
import com.dj.entity.Test;
import com.dj.entity.TestPaper;
import com.dj.entity.TestRecord;
import com.dj.entity.TpRelationq;
import com.dj.entity.User;
import com.dj.service.TestService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TestAction extends ActionSupport implements ModelDriven<Test>{
	private TestService testService;

	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	//模型驱动
	private Test test =new Test();
	public Test getModel() {

		return test;
	}
	
	
	private Integer uid;
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	//页面点击进入考试后开始考试
	   public String startTest(){
			
			 Test t = testService.ckTest();
			 User user = testService.ckUser(uid);
			 ActionContext.getContext().getValueStack().set("user", user);
			 TestRecord tr = new TestRecord();
			 tr.setUser(user);
			 tr.setTrdate(t.getTdate());
			 tr.setTrname(t.getTname());
			 //开始随机抽取试卷
			 TestPaper tp = testService.cqTestPaper();
			 ActionContext.getContext().getValueStack().set("tp", tp);
			 Date stime =new Date();
			 tr.setTestPaper(tp);
			 tr.setStime(stime);
			 //保存考试记录
			 testService.saveTestRecord(tr);
			 //查询考试记录
			 //TestRecord tr1 = testService.ckTestRecord(uid);
			 //通过id将试题和考试记录保存到答题情况表中
			 testService.saveQTR(tp,tr);
			 List<TpRelationq> listxzq=testService.ckxzq(tp.getTpid());
			 List<TpRelationq> listpdq=testService.ckpdq(tp.getTpid());
			 List<TpRelationq> listtkq=testService.cktkq(tp.getTpid());
			 ActionContext.getContext().getValueStack().set("listxzq", listxzq);
			 ActionContext.getContext().getValueStack().set("listpdq", listpdq);
			 ActionContext.getContext().getValueStack().set("listtkq", listtkq);
			 ActionContext.getContext().getValueStack().set("tr", tr);
			
			
			return "startTest";
		}
	   
	   /**
	    * 单元考试
	    */
	   public String unitTest(){
		   String qscope = ServletActionContext.getRequest().getParameter("qscope");
		   //查询符合范围的试题
		   List<Question> listxz = testService.ckxz(qscope);
		   List<Question> listpd = testService.ckpd(qscope);
		   List<Question> listtk = testService.cktk(qscope);
		   ActionContext.getContext().getValueStack().set("listxz", listxz);
		   ActionContext.getContext().getValueStack().set("listpd", listpd);
		   ActionContext.getContext().getValueStack().set("listtk", listtk);
		   
		   
		   
		   return "unitTest";
	   }
	   
	   /**
	    * 计算答题分数，显示答题详情
	    */
	   public String showResult(){
		   
		    String[] qid = ServletActionContext.getRequest().getParameterValues("qid");
			List<String> as = new ArrayList<String>(); 
	        //循环遍历页面上被选中的答案	
			for(int i=0;i<qid.length;i++){
				String answer =ServletActionContext.getRequest().getParameter(qid[i]);
				as.add(answer);
				answer = null;
			}
			Question q = null;
			List<Question> listq = new ArrayList<Question>();
			//找出测试中所有试题
			for(int i=0;i<qid.length;i++){
				q = testService.findQ(Integer.parseInt(qid[i]));
				listq.add(q);
				q = null ;
			}
			//计算分数
			int sum = 0;
			for(int i=0;i<6;i++){
				if(as.get(i).equals(listq.get(i).getQanswer())){
					sum+=10;
				}
			}
			for(int i=6;i<9;i++){
				if(as.get(i).equals(listq.get(i).getQanswer())){
					sum+=5;
				}
			}
			if(as.get(9).equals(listq.get(9).getQanswer())){
				sum+=25;
			}
			ActionContext.getContext().getValueStack().set("listq", listq);
			ActionContext.getContext().getValueStack().set("sum", sum);
			ActionContext.getContext().getValueStack().set("as", as);
			
		   
		   return "showResult";
	   }
	

}
