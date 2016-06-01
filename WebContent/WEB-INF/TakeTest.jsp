<%@page import="com.sd.pojo.UserPojo"%>
<%@page import="com.sd.pojo.TestPojo"%>
<%@page import="com.sd.model.TakeTest"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to Test</h1>

	<%
		UserPojo user = (UserPojo) session.getAttribute("user");
	TakeTest takeTest = new TakeTest();
	ArrayList<TestPojo> validTest = takeTest.getValidTest(user);

		for(TestPojo test:validTest){
			System.out.println(test);
			if(test!=null){
				int t=test.getTestId();
	%>
		<a href="TestProcess?testId=<%=test.getTestId()%>" >Click Here to Take Test <%out.println(test.getTestName()); %></a> </br>
	<%
			}
		}
	%>
</body>
</html>