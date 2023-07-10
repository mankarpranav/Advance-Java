<%@ page import="pojos.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h1 align='center'>Hello</h1>
<body>
<%
	String fname=request.getParameter("fn");
	String lname=request.getParameter("ln");
	int score=Integer.parseInt(request.getParameter("score"));
	Course course= Course.valueOf(request.getParameter("course").toUpperCase());
	Student s=new Student(fname,lname,score,course);
	request.setAttribute("Student1", s);
	if(s.getScore()>80)
	{
		s.setAdmitted(true);
		
		request.getRequestDispatcher("new_studnet.jsp").forward(request,response);
	}
	else
	{
		request.getRequestDispatcher("Reject_studnet.jsp").forward(request,response);
			
	}
%>
</body>
</html>