package com.sd.Impl;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import com.sd.Mapper.MapQuesTestMapper;
import com.sd.Mapper.QuestionMapper;
import com.sd.pojo.QuestionPojo;
import com.sd.pojo.MapQuesTestPojo;

public class MapQuesTestDaoImpl{
	
private JdbcTemplate jdbcTemplate;
	
	public MapQuesTestDaoImpl() {
		super();
	}

	public MapQuesTestDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Boolean addData(Integer testId, ArrayList<Integer> quesId) {
		
		
		for(int i=0;i<quesId.size();i++){
			String sql="insert into mapQuesTest(questionId,testId) values(?,?)";
			jdbcTemplate.update(sql,quesId.get(i),testId);
			System.out.println("Record Inserted!!!");	
		}
		
		
		return true;

	}

	public ArrayList<QuestionPojo> getTestQuestions(Integer testId) {
		// TODO Auto-generated method stub
		
		ArrayList<MapQuesTestPojo> mapQuesTestList = new ArrayList<MapQuesTestPojo>();
		
		String sqlgetQuestionId="select * from mapQuesTest where testId=?";
		String sqlgetQuestion ="select * from questions where questionId=?";
		
		ArrayList<QuestionPojo> questionList = new ArrayList<QuestionPojo>();
		
		mapQuesTestList=(ArrayList<MapQuesTestPojo>) jdbcTemplate.query(sqlgetQuestionId,new Object[]{testId}, new MapQuesTestMapper());
		for(MapQuesTestPojo i:mapQuesTestList){
			ArrayList<QuestionPojo> q = new ArrayList<QuestionPojo>();
			q=(ArrayList<QuestionPojo>) jdbcTemplate.query(sqlgetQuestion, new Object[]{i.getQuestionId()}, new QuestionMapper());
			questionList.add(q.get(0));
		}
		
		return questionList;
	}

}
