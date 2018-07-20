<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
     <c:set var="title" value="${cellpones.id == null ? '添加' : '修改'}"></c:set>
     <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout>    
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
					<li>${cellpone.images }</li>
					<li><img src="${contextPath }/assets/images/cellpone/${cellpone.images }" 
					width="100" height="100" align="middle"> </li>				
				</c:forEach>
			</ul>		
		</div>
</t:layout>