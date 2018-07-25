<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
     <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
     
 <t:layout>

	<h3>登陆页面</h3>
	
	<c:if test="${loginError }"><!-- 在控制类已经判断好的直接那就好了 -->
		<h5 style=" color:red;">用户名或密码错误</h5>
	</c:if>
		  <!-- 当退出后来到登录页面时，显示该消息 -->
	<c:if test="${param.logout != null}">
	    <h2>已退出，请重新登录</h2>
	</c:if>
	<form action="" method="post"><!-- post提交事为啥还不了解.有可能是第三方类需要 -->
	<sec:csrfInput />
		<div>
			<label for="username">用户</label><!--默认是username  -->
			<input type="text" name="username" id="username">
		</div>
		<div>
			<label for="password">用户</label><!-- 默认是password -->
			<input type="password" name="password" id="password">
		</div>
		<div>
			<button type="submit">登陆</button>
			<a href="${contextPath}/register"> 注册用户</a>
		</div>
	</form>
		

<br><br><br><br>

 </t:layout>