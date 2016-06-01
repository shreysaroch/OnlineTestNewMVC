<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
<script type="text/javascript">
function loginPage() {
	document.formSignUp.action="check.htm";
	document.formSignUp.submit();
}

</script>
</head>
<body>
<form:form name="formSignUp" modelAttribute="user" method="POST">
	<h2><center>User Login Page</center></h2>
	<div align="center"><form:errors id="InvalidUser" /></div>
	<table width="100%" height="150" align="center" border="0">
		<tr>
			<td width="50%" align="right">User ID</td>
			<td width="50%" align="left"><form:input path="userId" size="19"/></td>
		</tr>
		<tr>
			<td width="50%" align="right">User Name</td>
			<td width="50%" align="left"><form:input path="name" size="19"/></td>
		</tr>
		<tr>
			<td width="50%" align="right">Password</td>
			<td width="50%" align="left"><form:input path="password" size="19"/></td>
		</tr>
		<tr>
			<td width="50%" align="right" >Email</td>
			<td width="50%" align="left"><form:input path="email"  size="20"/></td>
		</tr>		
		<tr>
			<td width="50%" align="right" >Group ID</td>
			<td width="50%" align="left"><form:select path="groupId">
				<form:options items="${groupList}" itemValue="groupId" itemLabel="groupId" />
			</form:select></td>
		</tr>
		 <tr>
			<td colspan="2" align="center">
			<input type="button" value="Login" onClick="javascript:loginPage();"></td>
		 </tr>	
		 <tr>
				<td colspan="2" align="center"><font color="red">${message}</font></td>
			</tr>
		</table>

</form:form>
</body>
</html>