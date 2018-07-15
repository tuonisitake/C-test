package com.dj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dj.entity.AnswerSituation;
import com.dj.entity.BanJi;
import com.dj.entity.TestRecord;
import com.dj.entity.User;
import com.dj.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//模型驱动
	private User user =new User();
	public User getModel() {
		
		return user;
	}
	
	private Integer trid;

	public void setTrid(Integer trid) {
		this.trid = trid;
	}
	
	private String newPW;

	public void setNewPW(String newPW) {
		this.newPW = newPW;
	}
	
	private Integer aid;
	


	public void setAid(Integer aid) {
		this.aid = aid;
	}


	public String login(){

		User userExist=userService.login(user);
		
		//判断
		if(userExist != null)
		{
			//使用session保持状态登录
			HttpServletRequest request= ServletActionContext.getRequest();
			request.getSession().setAttribute("user", userExist);
			return "loginsuccess";
		} else {
			//失败
			return "login";
		}
	
		
		
	}
	
	
	//查看考试记录
	public String ckTestRecord(){
		List<TestRecord> list = userService.ckTestRecord(user.getUid());
		ActionContext.getContext().getValueStack().set("list", list);
		return "ckTestRecord";
	}
	
	//查看答题情况
	public String ckAnswerSituation(){
		//查看选择题答题情况
		List<AnswerSituation> xzqas = userService.ckxzqas(trid);
		//查看判断题答题情况
		List<AnswerSituation> pdqas = userService.ckpdqas(trid);
		//查看填空题答题情况
	    List<AnswerSituation> tkqas = userService.cktkqas(trid);
		ActionContext.getContext().getValueStack().set("xzqas", xzqas);
		ActionContext.getContext().getValueStack().set("pdqas", pdqas);
		ActionContext.getContext().getValueStack().set("tkqas", tkqas);
		
		return "ckAnswerSituation";
	}
	
	//查看我的班级
	public String myBanJi(){
		BanJi banJi = userService.findmyBanji(user.getUid());
		ActionContext.getContext().getValueStack().set("banJi", banJi);
		
		
		
		return "myBanJi";
	}
	
	//修改密码
	public String updatePW(){
		
		userService.updatePW(user.getUid(),newPW);
		
		
		return "updatePW";
	}
	/**
	 * 查看所有人员
	 */
	public String ckAllUser(){
		
		List<User> listu = userService.ckAllUser(aid);
		ActionContext.getContext().getValueStack().set("listu", listu);
		
		
		return "ckAllUser";
	}
	/**
	 * 删除成员
	 */
	public String deleteUser(){
		userService.deleteUser(user.getUid());
		List<User> listu = userService.ckAllUser(aid);
		ActionContext.getContext().getValueStack().set("listu", listu);
		
		
		return "ckAllUser";
	}
	/**
	 * 注销
	 */
	public String sessionDestroy(){
		ServletActionContext.getRequest().getSession().invalidate();
		
		
		return "sessionDestroy";
	}


}
