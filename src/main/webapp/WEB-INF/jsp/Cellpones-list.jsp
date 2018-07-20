<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:layout>

	<h3>手机商城</h3>
										<!-- 取得路劲下的图片，于jsp同级目录下开始                                    限制图片宽                    高度     -->
	<img src="${pageContext.request.contextPath}/assets/images/cellpone/cellpone_01.png"width="190" height="300" align="middle" >
	<div>
		<ul>
			<c:forEach items="${cellpone }" var="cellpones">
				<li>
				<a href="${contextPath }/cellpones/${cellpones.id }/details">
					<!--图片路径--获得当前的父文件的--同级文件 /下/下/下/${数据库取值文件名}-->
				 <img  src="${contextPath}/assets/images/cellpone/${cellpones.images }"
				  width="100" height="100" align="middle"></a></li>
				<li><a href="${contextPath }/cellpones/${cellpones.id }/details">${cellpones.brand }</a>				
				</li>																
			</c:forEach>		
		</ul>
	</div>
	</t:layout>



