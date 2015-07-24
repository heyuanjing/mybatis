<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="submain">
	<div class="subpage">
	<c:forEach items="${functions.groups }" var="group">
		<dl class="<c:if test='${group.groupId == groupFunction.groupId }'>on</c:if>">
			<dt class="num1">${group.name}</dt>
			<c:forEach items="${group.function }" var="function">
				<dd class="<c:if test='${function.functionId == groupFunction.functionId }'>on</c:if>">
					<a href="${pageContext.request.contextPath}${function.url}">${function.name }</a>
				</dd>
			</c:forEach>
		</dl>
	</c:forEach>
	</div>
</div>