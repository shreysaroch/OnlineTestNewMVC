package com.sd.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sd.pojo.TestPojo;

public class TestMapper implements RowMapper<TestPojo> {

	
	public TestPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
		TestPojo test=new TestPojo();
	
		test.setTestId(rs.getInt("id"));
		test.setTestName(rs.getString("testName"));
		test.setGroupId(rs.getInt("groupId"));
		test.setStartTime(rs.getTime("startTime"));
		test.setEndTime(rs.getTime("endTime"));
		test.setCorrectMarks(rs.getInt("correctMarks"));
		test.setIncorrectMarks(rs.getInt("incorrectMarks"));
		return test;
	}
}