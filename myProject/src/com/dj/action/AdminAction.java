package com.dj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dj.entity.Admin;
import com.dj.entity.AnswerSituation;
import com.dj.entity.TestRecord;
import com.dj.entity.User;
import com.dj.service.AdminService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminAction extends ActionSupport implements ModelDriven<Admin>{
	
	private AdminService adminService;
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	//模型驱动
	private Admin admin=new Admin();
	public Admin getModel() {
		
		return admin;
	}
	//新密码
	private String newPW;
	
	public void setNewPW(String newPW) {
		this.newPW = newPW;
	}
	private Integer trid;
	

	public void setTrid(Integer trid) {
		this.trid = trid;
	}
	private Integer uid;
	

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String login(){
		
		
		
        Admin adminExist=adminService.login(admin);
		
		//判断
		if(adminExist != null)
		{
			//使用session保持状态登录
			HttpServletRequest request= ServletActionContext.getRequest();
			request.getSession().setAttribute("admin", adminExist);
			return "loginsuccess";
		} else {
			//失败
			return "login";
		}
	}
	
	/***
	 * 查看我的信息
	 */
	public String ckMyInfo(){

		return "ckMyInfo";
	}
	/**
	 * 修改密码
	 */
	public String updatePW(){
		
		return "updatePW";
	}
	/**
	 * 修改密码实现
	 */
	public String updatePWSX(){
		adminService.updatePWSX(admin.getAid(),newPW);
		
		return "updatePWSX";
	}
	/**
	 * 删除考试记录
	 */
	public String deleteTestRecord(){
		adminService.deleteTestRecord(trid);
		
		return "deleteTestRecord";
	}
	/**
	 * 查看用户的考试记录
	 */
	public String ckTestRecord(){
		List<TestRecord> list = adminService.ckTestRecord(uid);
		ActionContext.getContext().getValueStack().set("list", list);
		return "ckTestRecord";
		
		
	}
	/**
	 * 查看用户的答题情况
	 */
	public String ckAnswerSituation(){
		
		//查看选择题答题情况
				List<AnswerSituation> xzqas = adminService.ckxzqas(trid);
				//查看判断题答题情况
				List<AnswerSituation> pdqas = adminService.ckpdqas(trid);
				//查看填空题答题情况
			    List<AnswerSituation> tkqas = adminService.cktkqas(trid);
				ActionContext.getContext().getValueStack().set("xzqas", xzqas);
				ActionContext.getContext().getValueStack().set("pdqas", pdqas);
				ActionContext.getContext().getValueStack().set("tkqas", tkqas);
		
		return "ckAnswerSituation";
	}
	
	/**
	 * 注销
	 */
	public String sessionDestory(){
		
		ServletActionContext.getRequest().getSession().invalidate();
		
		return "sessionDestory";
	}

	
	
}
