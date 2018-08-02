<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	详情页面<br>
				订单状态：${orders.stateText() }<br>
				${orders.createtime }<br>
	<table>
		<tr><th>商品</th><th>单价</th><th>数量</th></tr>
			<tr>
				<c:forEach items="${orders.ordersitem }" var="item">
					<td>${item.cellpones.brand }</td>
					<td>${item.cellpones.price }</td>
					<td>${item.ampout } </td><br>
					
				</c:forEach>				
			</tr>	
	</table>
	<div>
		<form action="${contextPath }/uc/Orders/${orders.id}/pay" method="post">
			<sec:csrfInput/>
			<button type="submit">支付宝付款</button>
		</form>
	</div>
</body>
</html>