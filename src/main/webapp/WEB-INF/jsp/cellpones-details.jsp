<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
	<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout><!-- 把详情页传往layout.tag页面 -->
	<div>
		<ul>
			
			<li><img  src="${contextPath}/assets/images/cellpone/${cellpones.images}"> </li>
			<li>${cellpones.brand }</li>
			<li>${cellpones.model }</li>
			<li>${cellpones.os }</li>
			<li>${cellpones.cpubrand }</li>
			<li>${cellpones.ram }</li>
			<li>${cellpones.color }</li>
			<li>${cellpones.price }</li>			
			<li><input type="text" name="${cellpones.description }" id="a" value="可以添加评价"></li>
		</ul>
	</div>
</t:layout>
