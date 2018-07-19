<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<t:layout>
	<h2>欢迎来到首页 http://localhost:8080/shop-in/</h2>
		<div>
		<ul>
			<c:forEach items="${cellpones }" var="cellpones">
			
				<li>
				<a href="${contextPath }/cellpones/${cellpones.id }/details">
				 <img  src="${contextPath}/assets/images/cellpone/${cellpones.images }"
				  width="100" height="100" align="middle"></a></li>
				<li><a href="${contextPath }/cellpones/${cellpones.id }/details">${cellpones.brand }</a>				
				</li>																
			</c:forEach>		
		</ul>
	</div>
</t:layout>
