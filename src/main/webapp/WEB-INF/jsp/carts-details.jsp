<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>购物车详情</h3>
	<div>
		<ul>
			<c:forEach items="${cartsItem.items }" var="item">
				<li>
				<img src="${contextPath }/assets/images/cellpone/${item.cellpones.images }"><br>${item.cellpones.brand} </li>
				<li>￥：${item.cellpones.price / 100 }美金</li>
				<li>${item.count }</li>				
				<li>
					<form action="${contextPath }/uc/carts/upteda" method="post">
					<sec:csrfInput/>
						<input type="hidden" name="cellponesId" value="${item.cellpones.id }">
						<button type="submit">取消订单</button>
					</form>					
				</li>
			</c:forEach>
		</ul>
		<a href="${contextPath }/">返回</a>
	</div>
</body>
</html>