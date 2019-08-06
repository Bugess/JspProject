<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UploadServlet" method="post" enctype="multipart/form-data">
		姓名：<input name="sname" type="text" /><br/>
		上传照片：<input name="spicture" type="file" /><br/>
		<input type="submit" value="注册"/>
	</form>
	
	<a href="DownloadServlet?fileName1=abc.png" >下载图片</a>
</body>
</html>