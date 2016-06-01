package com.sd.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sd.pojo.MapQuesTestPojo;

public class MapQuesTestMapper implements  RowMapper<MapQuesTestPojo>{
	
	public MapQuesTestPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
		MapQuesTestPojo map=new MapQuesTestPojo();
		map.setQuestionId(rs.getInt("questionId"));
		map.setTestId(rs.getInt("testId"));
		return map;
	}

}
