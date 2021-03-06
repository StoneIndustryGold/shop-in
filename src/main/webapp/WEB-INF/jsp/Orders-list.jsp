<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
     <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<t:layout title="订单详情页面">
		订单集合页<br>
		首先大得到当前用户，
		1 显示订单创建时间<br>
		2 显示订单项，<br>
		商品名称，   价格  数量，<br>
	
		3显示收货地址， 更改地址链接 重定向到订单详情页<br>
		
		<table>
		<tr><th>ID</th><th>商品</th><th>单价</th><th>数量</th><th>取消订单</th></tr>
			<c:forEach items="${orders}" var="order">
    订单创建时间：<fmt:formatDate value="${order.createtime }" pattern="yyyy-MM-dd HH:mm:ss"/><br>
					得到状态：${order.state}<br>
					
				<c:forEach items="${order.ordersitem }" var="item">
						${item.ampout}
						id#	${order.id}
					<tr>
						<td>${order.id }</td>
						<td><a href="${contextPath }/uc/Orders/details/${order.id}">
							${item.cellpones.brand}</a></td>
					
						<td>${item.cellpones.price }</td>
						<td>${item.ampout } <a href="${contextPath }/uc/Orders/details/${order.id}">详情</a></td>
						<td>
						<form:form action="${contextPath }/uc/Orders/delete/${order.id}" method="post">
							
							<button type="submit">取消订单</button>
						</form:form></td>
					</tr>
						
				</c:forEach>
				
			</c:forEach>
		</table>
</t:layout>