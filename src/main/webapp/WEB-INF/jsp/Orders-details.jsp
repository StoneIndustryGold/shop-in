<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<%-- 
	<c:forEach items="${addres }" var="addre">
		#${addre.id }
	</c:forEach>
	 <form:form action="" method="post" commandName="ordersForm"><!-- 不写form表单的话就调用实体 -->
		<div>
			<label for="AddressId"></label>
			<form:select path="AddressId" ><!--orders表单下的address收货的址对一关系  -->
				
				
				<form:options items="${addres}" 
							  itemLabel="detailsAddress"
							  itemValue="detailsAddress"/><!-- 传出去的 是id -->
				
			</form:select>
			<form:errors path="AddressId" cssClass="field-error" ></form:errors>
		</div>
		<button type="submit">修改</button>
		</form:form> --%>
</body>
</html>