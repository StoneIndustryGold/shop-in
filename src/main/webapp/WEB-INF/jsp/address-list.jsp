<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<ul>
			<c:forEach items="${addres }" var="addre">
				<li>名字:${addre.consigneeName }</li>
				<li>电话：${addre.phone }</li>
				<li>详情：${addre.detailsAddress }</li>
				
			</c:forEach>
		</ul>
	</div>
</body>
</html>