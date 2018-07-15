package com.dj.dao;

import com.dj.entity.TestRecord;

public interface TestRecordDao {

	TestRecord getTestRecord(Integer trid);

	void saveTestRecord(TestRecord tr);

}
