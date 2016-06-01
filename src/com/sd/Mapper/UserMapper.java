package com.sd.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sd.pojo.UserPojo;

public class UserMapper implements RowMapper<UserPojo> {

	
	public UserPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserPojo user=new UserPojo();
	
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		return user;
	}
	
}
