package com.sd.Impl;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import com.sd.Mapper.GroupInfoMapper;
import com.sd.pojo.GroupInfoPojo;

public class GroupInfoDaoImpl {
	
	private JdbcTemplate jdbcTemplate;
	
	public GroupInfoDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public boolean add(GroupInfoPojo group){
		String sql="INSERT INTO groupinfo value(?,?)";
		jdbcTemplate.update(sql,group.getGroupId(),group.getGroupName());
		System.out.println("Group INSERTED!!!");
		return true;
	}
	
	public ArrayList<GroupInfoPojo> getGroupList(){
		String sql="select * from groupInfo";
		ArrayList<GroupInfoPojo> groupList = new ArrayList<GroupInfoPojo>();
		groupList=(ArrayList<GroupInfoPojo>) jdbcTemplate.query(sql, new GroupInfoMapper());
		return groupList;
	}
}
