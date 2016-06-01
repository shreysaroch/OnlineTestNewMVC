package com.sd.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sd.pojo.GroupInfoPojo;
public class GroupInfoMapper implements RowMapper<GroupInfoPojo> {
	
	public GroupInfoPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
		GroupInfoPojo group = new GroupInfoPojo();
		group.setGroupId(rs.getInt("groupId"));
		group.setGroupName(rs.getString("groupName"));
		return group;
	}
}
