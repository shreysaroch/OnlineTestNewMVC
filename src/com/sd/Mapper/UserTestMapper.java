package com.sd.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sd.pojo.TestPojo;

public class UserTestMapper implements RowMapper<TestPojo>{
	 
    public TestPojo mapRow(ResultSet rs, int rownumber) throws SQLException {  
        TestPojo e=new TestPojo();
        e.setTestId(rs.getInt("testId"));
        e.setTestName(rs.getString("testName"));
        e.setStartTime(rs.getTime("startTime"));
        e.setEndTime(rs.getTime("endTime"));
        e.setGroupId(rs.getInt("groupId"));
        return e;  
    }  
    
}