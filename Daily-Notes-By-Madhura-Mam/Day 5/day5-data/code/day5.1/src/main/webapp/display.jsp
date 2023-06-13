<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5 align="center">
		JSESSIONID :
		<%=session.getId()%></h5>
	<h5>User Details via a Scriptlet</h5>
	<%
	//scriptlet containg java code ---> to show in _jspService method
	String email = request.getParameter("em");
	String password = request.getParameter("pass");
	out.print("<h4>Email : " + email + "</h4>");	/* out:same as printwriter in sevlets */
	out.print("<h4>Password : " + password + "</h4>");	
	%>
	<hr />
	<h5>User Details via a JSP expression</h5>
	<h4>
		Email :
		<%=request.getParameter("em")%></h4>		<!-- JSP expression -->
	<h4>
		Password :
		<%=request.getParameter("pass")%></h4>		
		<hr/>
		<h5>Guess the o/p</h5>
		<h5>page : <%= page %></h5>				
		<h5>pageContext : <%= pageContext %></h5>	<!-- usage- 1.2. -->
	<%-- 	<h5>exception : <%= exception %></h5> --%>	<!-- error as it is not error handling page -->
		
		<h5>session : <%= session %></h5>
		<hr/>
		<h5>User Details via a EL syntax</h5>
		<h5>Email : ${param.em}</h5>		<!-- request.getParameter("em") --sent to clnt -->
		<h5>Password : ${param.pass}</h5>
		<h5>param : ${param}</h5>		<!-- entire map in key-value pair -->
		
		<h5>Session ID ${pageContext.session.id}</h5>		<!-- pageContect.getSession.getId -->
</body>
</html>

<!-- page means this; refers the current page -->


