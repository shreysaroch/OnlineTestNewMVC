package com.sd.pojo;

import java.sql.Time;
import java.util.ArrayList;

public class TestPojo {
	
	@Override
	public String toString() {
		return "TestPojo [testId=" + testId + ", testName=" + testName
				+ ", groupId=" + groupId + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", correctMarks=" + correctMarks
				+ ", incorrectMarks=" + incorrectMarks + ", questionList="
				+ questionList + "]";
	}

	// auto increment and primary key 
	private Integer testId; // for mapping with question and test at mapQuesTest table
	
	private String testName;
	private Integer groupId; // for join with UserPojo
	private Time startTime;
	private Time endTime;
	private Integer correctMarks;
	private Integer incorrectMarks;
	private ArrayList<QuestionPojo> questionList;
	
	public TestPojo()
	{
			super();
	}

	public TestPojo(String testName, Integer groupId, Time startTime,
			Time endTime, Integer correctMarks, Integer incorrectMarks) {
		super();
		this.testName = testName;
		this.groupId = groupId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.correctMarks = correctMarks;
		this.incorrectMarks = incorrectMarks;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public Integer getCorrectMarks() {
		return correctMarks;
	}

	public void setCorrectMarks(Integer correctMarks) {
		this.correctMarks = correctMarks;
	}

	public Integer getIncorrectMarks() {
		return incorrectMarks;
	}

	public void setIncorrectMarks(Integer incorrectMarks) {
		this.incorrectMarks = incorrectMarks;
	}

	public ArrayList<QuestionPojo> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(ArrayList<QuestionPojo> questionList) {
		this.questionList = questionList;
	}
	
	
	
	
	

}
