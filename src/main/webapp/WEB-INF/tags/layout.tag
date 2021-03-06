<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <%@ attribute name="title" required="true" %>
<%@ attribute name="css" fragment="true" %> <!-- fragment设为true意味着该参数的值是标记片段 -->
<%@ attribute name="js" fragment="true" %>


<html>
	<head>
		<title>${title}</title>
		<link href="${contextPath}/assets/css/app.css" rel="stylesheet">
		<jsp:invoke fragment="css"/> <!-- 将css标记片段插入此处 -->
	</head>
	<body>
		<div class="header">
		
			<ul>
				<li><a href="${contextPath }/uc/carts/details">购物详情</a></li>
				<li><a href="${contextPath }/">手机商城</a></li>
				<li><a href="${contextPath }/uc/address/add">添加地址</a> </li>			
				<li><a href="${contextPath }/uc/address/list">地址详情</a> </li>	
				<li><a href="${contextPath }/uc/Orders/list">订单详情</a></li>		
			</ul>
		
			<!--手动创建的页面  -->
			<sec:authorize access="isAuthenticated()"> 
                 当前用户：<sec:authentication property="principal.username" /><br>
      	    性别：<sec:authentication property="principal.users.sex" /><br>
      	    年龄：<sec:authentication property="principal.users.age_id" /><br><!-- 设置别名方便取值 -->
	       登錄時間：<sec:authentication property="principal.users.lastLoginTime" var="lastLoginTime"/>
	       <fmt:formatDate value="${lastLoginTime }"
				      pattern="yyyy-MM-dd HH:mm:ss"/> <br>
	        当前地址：【${userProvince}】<br>  <!-- 得到省份地址 -->	    
      	    <sec:authentication property="principal.users.images" var="UsersImage" />
      	   														<!-- 取得图片名字 -->
      			<img  src="${contextPath }/assets/images/cellpone/${UsersImage}"
      			width="100" height="100" align="middle"><br>
      			
		      <form action="${contextPath}/logout" method="post" style="display: inline;">
		        <sec:csrfInput />
		        <button type="submit">退出</button>
		      </form>
		     </sec:authorize>
		     <sec:authorize access="isAnonymous()">
		     	<a href="${contextPath }/login">登录</a>&nbsp;&nbsp;&nbsp;
		     	<a href="${contextPath }/register">注册</a>
		     </sec:authorize>
    	</div> 
		     
		     
		    
		<div class="content">
			<br>
				${title }<br><!--插入jsp文件片段  -->
			<jsp:doBody />
		</div>
		<div class="footer">
			版权归石大仙联合出版社所有
		</div>
		<jsp:invoke fragment="js"/><!--插入js片段  -->
	</body>

</html>
