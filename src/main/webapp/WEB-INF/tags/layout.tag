<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
	<body>
		<div class="header">
			<ul>
				<li><a href="${contextPath }/users/list">作者列表</a></li>
				<li><a href="http://localhost:8080/shop/Cellpones/list">手机</a></li>
				
			</ul>
			
		</div>
		<div style="display: inline-block;">
<!--                                principal属性可以拿到当前登录的用户详情（UserDetailsImpl） -->
      		当前用户：	<sec:authentication property="principal.username" /><br>
      			性别：<sec:authentication property="principal.users.sex" /><br>
      			年龄：<sec:authentication property="principal.users.age_id" /><br>
    	</div> 
		<div class="content">
			<jsp:doBody />
		</div>
		<div class="footer">
			版权归石大仙联合出版社所有
		</div>
	</body>

</html>
