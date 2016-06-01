package com.sd.Impl;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.jdbc.core.JdbcTemplate;
import com.sd.Mapper.TestMapper;
import com.sd.pojo.QuestionPojo;
import com.sd.pojo.TestPojo;

public class TestDaoImpl{

	private JdbcTemplate jdbcTemplate;

	public TestDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	Integer getLastTetsId()
	{
		String sql="select * from test";
		ArrayList<TestPojo> testList = new ArrayList<TestPojo>();
		testList =(ArrayList<TestPojo>) jdbcTemplate.query(sql,new TestMapper());
		TestPojo test = (TestPojo)testList.get(testList.size()-1);
		return test.getTestId();
	}
	
	public Boolean addTest(TestPojo test) {
		// TODO Auto-generated method stub
		
		String sql="insert into test(testName,groupId,startTime,endTime,correctMarks,incorrectMarks) values(?,?,?,?,?,?)";
		jdbcTemplate.update(sql, test.getTestName(),test.getGroupId(),test.getStartTime(),test.getEndTime(),test.getCorrectMarks(),test.getIncorrectMarks());
		
		Iterator it = test.getQuestionList().iterator();
		ArrayList<Integer> quesId = new ArrayList<Integer>();
		
		while(it.hasNext())
		{
			QuestionPojo ques = (QuestionPojo)it.next();
			quesId.add(ques.getQuestionId());
		}
		
		MapQuesTestDaoImpl mapQuesTest = new MapQuesTestDaoImpl();
		mapQuesTest.addData(getLastTetsId(), quesId);

		System.out.println("Record Inserted!!!");	
		return true;		
	}
	
	
	public TestPojo getTest(Integer testId) {
		
		String sql="select * from test where testId=?";
		TestPojo test=jdbcTemplate.queryForObject(sql,new Object[]{testId}, new TestMapper());
		return test;
		
	}


	public ArrayList<Integer> getTestId(Integer groupId) {

		String sql="select * from test where groupId=?";
		ArrayList<TestPojo> testList = new ArrayList<TestPojo>();
		testList =(ArrayList<TestPojo>) jdbcTemplate.query(sql, new Object[]{groupId},new TestMapper());
		
		ArrayList<Integer> returnObj =  new ArrayList<Integer>();
		Iterator it = testList.iterator();
		while(it.hasNext())
		{
			TestPojo test = (TestPojo)it.next();
			returnObj.add(test.getTestId());
		}
		
		return returnObj;
	}

	
		
}


