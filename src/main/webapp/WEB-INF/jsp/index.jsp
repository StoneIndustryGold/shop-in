<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<t:layout>
		<h2>欢迎来到首页 http://localhost:8080/shop-in/</h2>
		
		<form:form action="${contextPath }/obscurefind/list" method="get">
			  <div>
					<label for="brand">牌子：</label> 
					<input type="text" name=brand id="brand" value="华为8" >	
			</div> 
			<div>
					<label for="os">系統:</label>
					<select name="os">
					<option value="">請選擇系統</option>
					<option value="IOS">IOS</option>
					<option value="Android">Android</option>
					<option value="Windows"> Windows</option>
					<option value=" Phone"> Phone</option>
				</select>
			</div>
			<div>
			品牌:<select name="cpubrand">
					<option value="">--品牌---</option>
					<option value="高通">高通</option>
					<option value="联发科">联发科</option>
				</select>
			</div>
		  <div>
				<label for="ram">內存</label>
					<select name="ram" id="ram">
					<option value="">多大內存</option>
					<option value="4">4</option>
					<option value="8">8</option>
					<option value="16">16</option>
				</select>
			</div>	 
				<button type="submit">
				搜索栏</button>
			
		</form:form>
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
