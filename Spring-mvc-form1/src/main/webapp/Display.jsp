<%@page import="com.org.Dto.Form"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${msg}</h1>
	<table border=2px>
		<tr> 
		<th>ID</th>	
		<th>AGE</th>
		<th>DOB</th>	
		<th>EMAIL</th>
		<th>GENDER</th>	
		<th>NAME</th>	
	</tr>
	<%
	List<Form> fm = (List<Form>) session.getAttribute("em");
	for(Form f : fm){
		%>
		<tr>
		<td><%=f.getId() %></td>
		<td><%=f.getAge() %></td>
		<td><%=f.getDob() %></td>
		<td><%=f.getEmail() %></td>
		<td><%=f.getGender() %></td>
		<td><%=f.getName() %></td>
		<td><a href="edit?id=<%= f.getId() %>">edit</a></td>
		<td><a href="delete?id=<%= f.getId() %>">delete</a></td>
		</tr>
	<%}
	%>
	</table>
</body>
</html>