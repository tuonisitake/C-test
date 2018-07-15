package com.dj.action;

import com.dj.entity.TestRecord;
import com.dj.service.TestRecordService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TestRecordAction extends ActionSupport implements ModelDriven<TestRecord>{
	private TestRecordService testRecordService;

	public void setTestRecordService(TestRecordService testRecordService) {
		this.testRecordService = testRecordService;
	}

	//模型驱动
	private TestRecord testRecord=new TestRecord();
	public TestRecord getModel() {
		
		return testRecord;
	}
	
	//考试结束（交卷或到时间）,记录考试结束时间
	public String endTest(){
		
		testRecordService.endTestTime(testRecord.getTrid());
		
		
		return "endTest";
	}
	

}
