package com.dj.action;

import com.dj.entity.TpRelationq;
import com.dj.service.TpRelationqService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TpRelationqAction extends ActionSupport implements ModelDriven<TpRelationq>{
	private TpRelationqService tpRelationqService;

	public void setTpRelationqService(TpRelationqService tpRelationqService) {
		this.tpRelationqService = tpRelationqService;
	}

	//Ä£ÐÍÇý¶¯
	private TpRelationq tpRelationq=new TpRelationq();
	public TpRelationq getModel() {
		
		return tpRelationq;
	}
	

}
