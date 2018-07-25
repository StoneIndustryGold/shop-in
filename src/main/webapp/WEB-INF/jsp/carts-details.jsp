<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
      <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
      
<t:layout>

	<h3>购物车详情</h3>
	<div>
		<ul>
			<c:forEach items="${cartsItem.items }" var="item">
				<li>
				<img src="${contextPath }/assets/images/cellpone/${item.cellpones.images }"><br>${item.cellpones.brand} </li>
				<li>￥：${item.cellpones.price / 100 }美金</li>
							
				<li>
					<form action="${contextPath }/uc/carts/upteda" method="post">
						<sec:csrfInput/>
							<input type="hidden" name="cellponesId" value="${item.cellpones.id }">
							<button type="submit">取消订单</button>
					</form>	<br>
					<form action="${contextPath }/uc/carts/uptedaCartsAdd" method="post">
						<sec:csrfInput/>
						<input type="hidden" name="cellponesId" value="${item.cellpones.id }">
						<button type="submit"><h3>+</h3></button>
					</form>	
					<li>${item.count }</li>				
					<form action="${contextPath }/uc/carts/uptedaCarts" method="post">
						<sec:csrfInput/>
						<input type="hidden" name="cellponesId" value="${item.cellpones.id }">
						<button type="submit"><h1>-</h1></button>
					</form>				
				</li>				
			</c:forEach>		
		</ul>
	</div>
	<div>
		总价：${cartsItem.totalCost() /100}元，数据库是分
	</div>
		<a href="${contextPath }/">返回</a>
		<br><br><br><br><br><br><br><br><br><br>
</t:layout>