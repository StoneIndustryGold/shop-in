<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
        
<t:layout title="注册">
	 	<jsp:attribute name="css">
    		<link href="${contextPath}/assets/css/form.css" rel="stylesheet">
  		</jsp:attribute>
  		<jsp:body>
		<form:form action="/uc/address/add" method="post" commandName="users">
			<sec:csrfInput />
		<div>
			<label for="username">用户</label><!--默认是username  -->
			<form:input type="text" path="username" id="username"/>
			<form:errors path="username" cssClass="field-error"></form:errors>
		</div>
		<div>
			<label for="password">密码</label><!-- 默认是password -->
			<form:input type="password" path="password" id="password" />
			<form:errors path="password" cssClass="field-error"></form:errors>
		</div>
		<div>
			<label for="sex">添加性别</label><!-- 单选按钮 -->
			<form:radiobutton path="sex" value="男"/>男
			<form:radiobutton path="sex"  value="女"/>女
			<form:errors path="sex" cssClass="field-error"></form:errors>
		</div>
		<div>
			<label for="age_id">年龄</label>
			<form:input path="age_id" min="10" max="120"/>
			<form:errors path="age_id" cssClass="field-error"></form:errors>
		</div>
		<div>
			<label for="gmail">邮箱</label>
			<form:input path="gmail"/>
			<form:errors path="gmail" cssClass="field-error"></form:errors>
		</div>
		<div>
			<label for="images">图像</label>
			<form:select path="images">
				<form:option value="">--请选择--</form:option>
				<form:option value="cellpone_01.png">--图1--</form:option>
				<form:option value="cellpone_02.png">--图2--</form:option>
				<form:option value="cellpone_03.png">--图3--</form:option>
				<form:option value="cellpone_04.png">--图4--</form:option>
				<form:option value="cellpone_05.png">--图5--</form:option>
				<form:option value="cellpone_06.png">--图6--</form:option>
				<form:option value="cellpone_07.png">--图7--</form:option>
				<form:option value="cellpone_08.png">--图8--</form:option>
				<form:option value="cellpone_09.png">--图9--</form:option>
				<form:option value="cellpone_10.png">--图10--</form:option>
				<form:option value="cellpone_11.png">--图11--</form:option>
				<form:option value="cellpone_12.png">--图12--</form:option>
				<form:option value="cellpone_13.png">--图13--</form:option>
				<form:option value="cellpone_14.png">--图14-</form:option>				
			</form:select>
			<form:errors path="images" cssClass="field-error"></form:errors>
		</div>
			
		<div>
			<button type="submit">注册</button>		
		</div>
	</form:form>
	</jsp:body>	

</t:layout>