<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout title="订单详情页面">
	
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
</t:layout>