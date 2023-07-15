<%@ page import="pojos.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
    int a = 1;
    int b = 0;
%>
<% Student s = (Student) request.getAttribute("Student1");
    System.out.println(s);
%>
<!-- Cast to Student class is needed as it calls the getter methods that use camel casing -->
<h1>Hello, ${requestScope.Student1.firstName} ${requestScope.Student1.lastName}</h1>
<hr>
<%-- <h1>Hello, ${param.fn} ${param.ln} Welcome To IACSD</h1> --%>
<%
    if (s.isAdmitted()) {
%>
        <h1>Welcome to IACSD! You have been selected for the course ${requestScope.Student1.selectedCourse}</h1>
<%
    } else {
%>
        <h1>Sorry, you have not been selected for the course ${requestScope.Student1.selectedCourse}</h1>
<%
    }
%>
</body>
</html>
