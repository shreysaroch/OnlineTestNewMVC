package com.sd.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import com.sd.Mapper.UserTestMapper;
import com.sd.pojo.TestPojo;


public class UserTestDaoImpl {
	private JdbcTemplate jdbcTemplate;  

	public void setTemplate(JdbcTemplate template) {  
		this.jdbcTemplate = template;  
	}  
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public UserTestDaoImpl(JdbcTemplate template) {
		super();
		this.jdbcTemplate = template;
	}



	public List<TestPojo> getUserTests(int groupId){  

		try{

			String sql = "select * from test where groupId ='" + groupId + "'";
			ArrayList<TestPojo> p = new ArrayList<TestPojo>();
			p = (ArrayList<TestPojo>) jdbcTemplate.query(sql,new UserTestMapper()); 
			System.out.println("Hell Yeah!!");
			return (List<TestPojo>) p;

		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}  


}


