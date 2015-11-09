<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- Ajax通信による検索 -->
<br>
<table border="1">
<tr>
<th>名前</th>
<th>住所</th>
<th>詳細</th>
<th>カテゴリ</th>
</tr>
<c:forEach items="${shopList}" var="shop">
<tr>
<td><c:out value="${shop.name}"></c:out></td>
<td><c:out value="${shop.address}"></c:out></td>
<td><c:out value="${shop.detail}"></c:out></td>
<td><c:out value="${shop.categoryName}"></c:out></td>
</tr>
</c:forEach>
</table>
<br>
