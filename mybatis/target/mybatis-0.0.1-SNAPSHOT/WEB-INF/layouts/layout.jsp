<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="Keywords" content=" " />
<meta name="Description" content=" " />
<title>标题</title>
<link href="${pageContext.request.contextPath }/resources/css/common.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ib.js"></script>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="page">
		<%@include file="left.jsp"%>
		<div class="main">
			<tiles:insertAttribute name="body" />
		</div>
		<div class="caveat">高风险交易警告：我们的服务包括保证金交易产品，其中涉及较高的风险，您可能损失全部的初始存款。在决定交易保证金产品之前，您应当综合考虑自己的投资目标、风险承受能力和您对这些产品的交易经验。高杠杆的交易可能赚钱也可能亏损。保证金产品未必适合所有人，您应当确保理解相关的风险。此外，您应该理解所有有关保证金产品的交易风险，必要时需求独立财务意见。请详阅《MDFFX风险披露申明》</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>