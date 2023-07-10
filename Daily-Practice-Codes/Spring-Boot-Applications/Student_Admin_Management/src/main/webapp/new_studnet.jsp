<%@ page import="pojos.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>a%re$sAAAAAAAAp;o
<meta charset="UTF-8">s
<title>Insert title here</title>
</head>
<body>
<%!
 int a=1;
int b=0;
%>
<%Student s=(Student)request.getAttribute("Student1"); System.out.println(s);%>
<!-- Campel cassing needed  as it call to getter Which use campel casing -->
<h1> Hello,${requestScope.Student1.firstName} ${requestScope.Student1.lastName}</h1>
<hr>
<%-- <h1> Hello,${param.fn} ${param.ln} Welcome To IACSD  </h1> --%>
<%

if(s.isAdmitted())
{ %>
	<h1> Welcome To IACSD ,You Got Selected For Course ${requestScope.Student1.selectedCourse}</h1>
<%}else
{%>
<h1> Sorry,You Not Selected For Course ${requestScope.Student1.selectedCourse}</h1>
<%
}
%>
</body>
</html>