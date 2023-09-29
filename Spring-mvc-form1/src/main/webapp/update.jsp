<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="update" modelAttribute="stu">
		NAME 	:<form:input path="name"/><br>
		AGE 	:<form:input path="age"/><br>
		EMAIL 	:<form:input path="email"/><br>
		GENDER 	:<form:input path="gender"/><br>
		DOB 	:<form:input path="dob"/><br>
				<form:button>Submit</form:button>
	</form:form>
</body>
</html>