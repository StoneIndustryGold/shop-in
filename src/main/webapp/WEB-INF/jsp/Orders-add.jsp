<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<t:layout title="正在生成订单......">
 	<jsp:attribute name="css">
    	<link href="${contextPath}/assets/css/form.css" rel="stylesheet">
  	</jsp:attribute>	
		
 <jsp:body>  		
	<div>
		<ul>
			<c:forEach items="${cartsItem.items }" var="item">
				<li>${item.cellpones.brand}</li>	
				<li>￥：${item.cellpones.price / 100 }美金</li>	
				<li>${item.count}</li><!-- 购物车项，和购物车的区别要搞清 -->	
			</c:forEach>			
		</ul>
		<div>
			总记：${cartsItem.totalCost() / 100 } 元
		</div>
	</div>
	 <form:form action="" method="post" commandName="ordersForm"><!-- 不写form表单的话就调用实体 -->
		<div>
			<label for="AddressId"></label>
			<form:select path="AddressId" ><!--orders表单下的address收货的址对一关系  -->
				
				<form:option value="">--请选择-- </form:option>
				<form:options items="${addres}" 
							  itemLabel="detailsAddress"
							  itemValue="id"/><!-- 传出去的 是id -->
				
			</form:select>
			<form:errors path="AddressId" cssClass="field-error" ></form:errors>
		</div>
				<div>
					<button type="submit">提交</button>
				</div>
	</form:form> 
</jsp:body>	
</t:layout>



