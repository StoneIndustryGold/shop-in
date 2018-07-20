<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
     <c:set var="title" value="${cellpones.id == null ? '添加' : '修改'}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>模糊查询页面</h2>
		<div>
			<ul>
				<c:forEach items="${cellpone }" var="cellpone">
					<li>${cellpone.brand }</li>
					<li>${cellpone.model }</li>
					<li>${cellpone.os }</li>
					<li>${cellpone.cpubrand }</li>
					<li>${cellpone.ram }</li>
					<li>${cellpone.color }</li>
					<li>${cellpone.description }</li>
					<li><img src="${contextPath }/assets/images/cellpone/${cellpone.images }" 
					width="100" height="100" align="middle"> </li>
					
					
				</c:forEach>
			</ul>		
		</div>
</body>
</html>