<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
	<body>
		<div class="header">
			<ul>
				<li><a href="${contextPath }/users/list">作者列表</a></li>
				<li><a href="http://localhost:8080/shop/cellpones/add">手机</a></li>
			</ul>
		</div>
		<div class="content">
			<jsp:doBody />
		</div>
		<div class="footer">
			版权归石大仙联合出版社所有
		</div>
	</body>

</html>
