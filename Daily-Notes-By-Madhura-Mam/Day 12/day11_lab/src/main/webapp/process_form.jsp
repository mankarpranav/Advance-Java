<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:setProperty property="*" name="ipl" />
<body>
<%--invoke B.L method of a bean to validate n add player --%>
<h5>Status : ${applicationScope.ipl.validateAndAddPlayer()}</h5>
</body>
</html>