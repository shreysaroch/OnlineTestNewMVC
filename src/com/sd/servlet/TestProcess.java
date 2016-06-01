package com.sd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sd.Impl.MapQuesTestDaoImpl;
import com.sd.Impl.UserTestDaoImpl;
import com.sd.pojo.QuestionPojo;

/**
 * Servlet implementation class TestProcess
 */
public class TestProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		int testId =Integer.parseInt(request.getParameter("testId"));
		ApplicationContext factory=new ClassPathXmlApplicationContext("SpringBeanConfiguration.xml");
		MapQuesTestDaoImpl mapQuesTest = (MapQuesTestDaoImpl) factory.getBean("mapQuesTestDao");
		
		ArrayList<QuestionPojo> qList = new ArrayList<QuestionPojo>();
		qList=mapQuesTest.getTestQuestions(testId);
		HttpSession session=request.getSession(false);
		session.setAttribute("Question List",qList);
		
		RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
