<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>

<div class="submain">
	<div class="subpage">
		<dl class="on">
			<dt class="num1">账户资料</dt>
			<dd class="on">
				<a href="${pageContext.request.contextPath}/account/index.html">账户摘要</a>
			</dd>
			<dd>
				<a href="${pageContext.request.contextPath}/account/personal.html">个人资料</a>
			</dd>
			<dd>
				<a href="${pageContext.request.contextPath}/account/contact.html">联络资料</a>
			</dd>
		</dl>
		<dl>
			<dt class="num2">资金调动</dt>
			<dd>
				<a
					href="${pageContext.request.contextPath}/funds/deposit/index.html">存款</a>
			</dd>
			<dd>
				<a
					href="${pageContext.request.contextPath}/funds/withdraw/index.html">取款</a>
			</dd>
			<dd>
				<a
					href="${pageContext.request.contextPath}/funds/transfer/index.html">转账</a>
			</dd>
			<dd>
				<a
					href="${pageContext.request.contextPath}/funds/perfect/index.html">补充/更改银行资料</a>
			</dd>
		</dl>
		<dl>
			<dt class="num3">推广链接</dt>
			<dd>
				<a href="${pageContext.request.contextPath}/promotion/index.html">推广链接</a>
			</dd>
		</dl>
		<dl>
			<dt class="num4">客户管理</dt>
			<dd>
				<a href="#">客户管理</a>
			</dd>
		</dl>
	</div>
</div>