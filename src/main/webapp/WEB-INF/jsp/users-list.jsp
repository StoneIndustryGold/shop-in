<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<t:layout>
	<h3>用户</h3>
	<div>
		<ul>
			<c:forEach items="${users }" var="users">
			<li>${users.username }</li>
			
			<li>
				<fmt:formatDate value="${users.lastLoginTime }"
				      pattern="yyyy-MM-dd HH:mm:ss"/>
			</li>
			</c:forEach>
		</ul>
	</div>

</t:layout>