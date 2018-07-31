<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
      <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
      
<t:layout title="购物车详情">
	<jsp:attribute name="css">
		<link href="${contextPath}/assets/css/form.css" rel="stylesheet">
	</jsp:attribute>
	
	<jsp:attribute name="js">
    <script src="${contextPath}/assets/vendor/jquery-3.3.1.min.js"></script>
    <script src="${contextPath}/assets/js/shopping-cart.js"></script><!-- ajax导入 -->
  </jsp:attribute>
	<jsp:body>
	<h5>购物车详情</h5>
	
		<c:if test="${cartsItem.totalCost() /100 !=0}">
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
							<li>
								<sec:csrfInput />		
								<input type="number" min="1" value="${item.count}" 
		                       class="item-count" 
		                       data-cellpones-id="${item.cellpones.id}">  
             				</li>
						
						
								
					</c:forEach>		
				</ul>
			</div>
			<div>
				<div>总价：${cartsItem.totalCost() /100}元，数据库是分</div>
				<a href="${contextPath }/uc/Orders/add">马上交钱</a>
			</div>	
		</c:if>	
			<c:if test="${cartsItem.totalCost() /100 ==0}">
								<h4>一首空空送给你</h4> <a href="${contextPath }/">世界很大，逛一下</a>
							</c:if><br> 	
		<a href="${contextPath }/">返回</a>
		</jsp:body>
</t:layout>
		<br><br><br><br><br><br><br><br><br><br>























