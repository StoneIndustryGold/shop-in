<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
     <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
     <c:set var="title" value="${addres.id == null ? '添加' : '修改'}"></c:set>
     
<t:layout title="${title}">
		<jsp:attribute name="css">
			<link href="${contextPath}/assets/css/form.css" rel="stylesheet">
		</jsp:attribute>
	<jsp:body>	
	<form:form action="" method="post" commandName="address">
	
	
			<div>
				<label for="consigneeName">收货人姓名</label>
				<form:input type="text" path="consigneeName" id="consigneeName" value="${addres.consigneeName }"/>
				<form:errors path="consigneeName" cssClass="field-error"></form:errors>
			</div>
			<div>
				<label for="phone">电话号码</label>
				<form:input type="text" path="phone" id="phone" value="${addres.phone }"/>				
				<form:errors path="phone" cssClass="field-error" ></form:errors>
			</div>
			<div>
				<label for="detailsAddress">详细地址</label>
				<form:input type="text" path="detailsAddress" id="detailsAddress" value="${addres.detailsAddress }"/>
				<form:errors path="detailsAddress" cssClass="field-error" ></form:errors>
			</div>			
			<div>			
				<button type="submit">${title}</button>
			</div>
			<div>
			</div>
		
	</form:form>
	</jsp:body>
</t:layout>