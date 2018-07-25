<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<body>
		<div class="header">
		
			<ul>
				<li><a href="${contextPath }/uc/carts/details">购物详情</a></li>
				<li><a href="${contextPath }/">手机商城</a></li>
				<li><a href="${contextPath }/uc/address/add">添加地址</a> </li>			
				<li><a href="${contextPath }/uc/address/list">地址详情</a> </li>			
			</ul>
		
		
			<sec:authorize access="isAuthenticated()"> 
                 当前用户：<sec:authentication property="principal.username" /><br>
      	    性别：<sec:authentication property="principal.users.sex" /><br>
      	    年龄：<sec:authentication property="principal.users.age_id" /><br><!-- 设置别名方便取值 -->
	       登錄時間：<sec:authentication property="principal.users.lastLoginTime" var="lastLoginTime"/>
	       <fmt:formatDate value="${lastLoginTime }"
				      pattern="yyyy-MM-dd HH:mm:ss"/> <br>    	    
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
			<jsp:doBody />
		</div>
		<div class="footer">
			版权归石大仙联合出版社所有
		</div>
	
	</body>

</html>
