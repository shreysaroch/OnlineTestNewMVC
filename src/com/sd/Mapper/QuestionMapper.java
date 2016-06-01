package com.sd.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.sd.pojo.QuestionPojo;


public class QuestionMapper implements RowMapper<QuestionPojo>{
	public QuestionPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
		QuestionPojo question=new QuestionPojo();
		question.setQuestionId(rs.getInt("questionId"));
		question.setQuestion(rs.getString("question"));
		question.setOptionA(rs.getString("optionA"));
		question.setOptionB(rs.getString("optionB"));
		question.setOptionC(rs.getString("optionC"));
		question.setOptionD(rs.getString("optionD"));
		question.setAns(rs.getInt("ans"));
		return question;
	}
}
