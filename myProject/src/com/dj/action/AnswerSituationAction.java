package com.dj.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.dj.entity.AnswerSituation;
import com.dj.service.AnswerSituationService;
import com.mysql.fabric.xmlrpc.base.Array;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AnswerSituationAction extends ActionSupport implements ModelDriven<AnswerSituation>{
	
	
	private AnswerSituationService answerSituationService;
	public void setAnswerSituationService(
			AnswerSituationService answerSituationService) {
		this.answerSituationService = answerSituationService;
	}
	//模型驱动
    private AnswerSituation answerSituation=new AnswerSituation();
	public AnswerSituation getModel() {
	
		return answerSituation;
	}
	private Integer trid;
	public void setTrid(Integer trid) {
		this.trid = trid;
	}
	
	/**
	 * 保存答题情况
	 */
	public String saveAS(){
		
		String[] qid = ServletActionContext.getRequest().getParameterValues("qid");
		List<String> as = new ArrayList<String>(); 
        //循环遍历页面上被选中的答案	
		for(int i=0;i<qid.length;i++){
			String answer =ServletActionContext.getRequest().getParameter(qid[i]);
			as.add(answer);
			answer = null;
		}
		for(int i=0;i<qid.length;i++){
			answerSituationService.saveAS(trid,Integer.parseInt(qid[i]),as.get(i));
		}
		//保存结束时间
		    answerSituationService.upEndTime(trid);
		
		

		return "testend";
	}
	

}
