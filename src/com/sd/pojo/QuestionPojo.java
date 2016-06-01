package com.sd.pojo;

import java.util.ArrayList;

public class QuestionPojo {
	
	// auto increment primary key
	private Integer questionId; // for mapping with question and test at mapQuesTest table
	
	private String question;
	private String optionA, optionB, optionC, optionD;
	private Integer ans;
	
	public QuestionPojo()
	{
		super();
	}
	
	public QuestionPojo(String question, String optionA, String optionB,
			String optionC, String optionD, Integer ans) {
		super();
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.ans = ans;
	}



	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public Integer getAns() {
		return ans;
	}

	public void setAns(Integer ans) {
		this.ans = ans;
	}
	
	
}
