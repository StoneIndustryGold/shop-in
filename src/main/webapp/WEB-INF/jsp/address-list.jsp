<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>

	<div>
		<ul>
			<c:forEach items="${addres }" var="addre">
				<li>名字:${addre.consigneeName }</li>
				<li>电话：${addre.phone }</li>
				<li>详情：${addre.detailsAddress }</li>
				<a href="${contextPath }/uc/address/${addre.id}/update">编辑地址</a><br>
				<li>
					<form action="${contextPath }/uc/address/${addre.id}/delete" method="post">
						<sec:csrfInput/>
						<button type="submit">删除地址</button>
					</form>
				</li>
			</c:forEach>
		</ul>
	</div>
</t:layout>
