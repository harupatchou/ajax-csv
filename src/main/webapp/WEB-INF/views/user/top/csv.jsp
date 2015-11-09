<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">
	
<h1>下記の情報を登録しますか？</h1>

<table border="1">
<tr>
<th>id</th>
<th>名前</th>
<th>住所</th>
<th>詳細</th>
<th>カテゴリ</th>
</tr>
<c:forEach items="${csvList}" var="csv">
<tr>
<td><c:out value="${csv.id}"></c:out></td>
<td><c:out value="${csv.name}"></c:out></td>
<td><c:out value="${csv.address}"></c:out></td>
<td><c:out value="${csv.detail}"></c:out></td>
<td>
<c:if test="${csv.categoryId == 1}">中華</c:if>
<c:if test="${csv.categoryId == 2}">和食</c:if>
<c:if test="${csv.categoryId == 3}">洋食</c:if>
</td>
</tr>
</c:forEach>
</table>

<form action="/user/csv/insert">
<input type="submit" value="登録" />
</form>
<form action="/user/top">
<input type="submit" value="戻る" />
</form>

<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>