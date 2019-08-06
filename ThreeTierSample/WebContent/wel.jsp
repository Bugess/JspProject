<%@page import="com.dzkj.student.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery/jquery-1.8.3.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("tr:odd").css("background-color","lightgray");
		});
	
	</script>
</head>
<body>
	<%

		//增加提示
			String error = (String) request.getAttribute("error");
			if (error != null) {
				if (error.equals("addError")) {
					out.print("增加失败！！");
				} else if (error.equals("noAddError")) {
					out.print("增加成功！！");
				}
			}
	%>

	<table border="1px">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>操作</th>
		</tr>

		<%
			@SuppressWarnings("unchecked")
			List<Student> students = (List<Student>) request.getAttribute("students");
			for (Student student : students) {
		%>
		<tr class="${s.id%2==0?'even':'odd'}">
			<td><a href="queryStudentServlet?sno=<%=student.getSno()%>"><%=student.getSno()%></a></td>
			<td><%=student.getSname()%></td>
			<td><%=student.getSage()%></td>
			<td><a href="delStudentServlet?sno=<%=student.getSno()%>">删除</a>
			</td>
		</tr>
		<%
			}
		%>

	</table>
	<a href="add.jsp">新增</a>
</body>
</html>