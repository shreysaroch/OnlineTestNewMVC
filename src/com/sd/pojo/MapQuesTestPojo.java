package com.sd.pojo;

public class MapQuesTestPojo {
	
	//primary key (questionId, testId)
	private Integer questionId; //foreign key with QuestionPojo
	private Integer testId;	 // foreign key with TestPojo
	
	public MapQuesTestPojo()
	{
		super();
	}

	public MapQuesTestPojo(Integer questionId, Integer testId) {
		super();
		this.questionId = questionId;
		this.testId = testId;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	
}
