package com.sd.Impl;

import com.sd.Mapper.UserMapper;
import com.sd.pojo.UserPojo;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl {

	private JdbcTemplate jdbcTemplate;

	public UserDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public Boolean addUser(UserPojo user ) {

		// TODO Auto-generated method stub
		try{
			String sql="insert into user(userId,name, password,email,groupId) values(?,?,?,?,?)";		
			jdbcTemplate.update(sql,user.getUserId(), user.getName(),user.getPassword(), user.getEmail(),user.getGroupId());
			System.out.println("Account created");	
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Check your credentials");
			return false;
		}
	}


	public UserPojo getUser(String email, String password){  

		try{
			String sql = "select * from user where email='" + email + "' and password='"+password+"'";
			System.out.println("Checking for Valid User.");
			UserPojo p=(UserPojo)getJdbcTemplate().queryForObject(sql,new UserMapper());
			System.out.println("USer in IMPL....."+p.getName());
			return p;

		}
		catch(Exception e){
			e.printStackTrace();

			return null;


		}
	}
	
	public boolean checkExistenceofUser(int userId){
		Integer cnt = jdbcTemplate.queryForObject(
			    "SELECT count(*) FROM user WHERE userId = ?", Integer.class, userId);
		return cnt != null && cnt > 0;
		
		
	}

}



