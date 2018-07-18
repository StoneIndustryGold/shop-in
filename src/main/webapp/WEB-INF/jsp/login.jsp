<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>登陆页面</h3>
	
	<c:if test="${loginError }"><!-- 在控制类已经判断好的直接那就好了 -->
		<h5 style=" color:red;">用户名或密码错误</h5>
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
		</div>
	</form>


</body>
</html>