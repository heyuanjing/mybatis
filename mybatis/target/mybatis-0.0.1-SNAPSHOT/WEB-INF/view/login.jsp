<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="Keywords" content=" " />
<meta name="Description" content=" " />
<title>登录</title>
<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="loginPage">
		<div class="loginMain">
			<h2>登录到MDFFX</h2>
			<form:form modelAttribute="loginForm" id="loginForm" action="${pageContext.request.contextPath}/passer/login.html" method="post">
				<div class="error">
					<form:errors path="error" cssStyle="color:red;" />
				</div>
				<div class="input">
					<form:input path="username" cssClass="username h38" placeholder="请输入您的用户名！" />
				</div>
				<div class="input">
					<form:password path="password" cssClass="password h38" placeholder="请输入您的用户密码！" />
				</div>
				<div class="input auto">
					<form:checkbox path="isAutoLogin" value="true" cssStyle="vertical-align: middle;" />
					&nbsp;下次自动登录
				</div>
				<a href="#" class="btn" id="loginCheck">登录</a>
			</form:form>
		</div>
		<div class="loginInfo">
			<div class="txt">
				<p>高风险交易警告：我们的服务包括保证金交易产品，其中涉及较高的风险，您可能损失全部的初始存款。在决定交易保证金产品之前，您应当综合考虑自己的投资目标、风险承受能力和您对这些产品的交易经验。高杠杆的交易可能赚钱也可能亏损。保证金产品未必适合所有人，您应当确保理解相关的风险。此外，您应该理解所有有关保证金产品的交易风险，必要时需求独立财务意见。请详阅《MDFFX风险披露申明》</p>
			</div>
			<div class="cr">&copy; 2014 Copyright Forex Capital Markets All Rights Reserved</div>
		</div>
	</div>
	<div class="loginBg">
		<img src="${pageContext.request.contextPath}/resources/img/login_bg.jpg">
	</div>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.nicescroll.js"></script>
	<script src="${pageContext.request.contextPath}/resources/bizJs/passer_login.js"></script>
</body>
</html>