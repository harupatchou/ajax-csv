<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">

登録前時間　：　${lastDate}
<h1>店舗一覧表示</h1>
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

<form action="/shop/insertIndex">
<input type="submit" value="通常の店舗登録" />
</form>

<hr id=ht>
<!-- Ajax通信による登録 -->
<div id="ajaxRe">
<c:import url="/WEB-INF/views/shop/insert/ajax.jsp" charEncoding="UTF-8"/>
</div>
<input type="button" value="Ajax店舗登録" id="ajaxInsert"/>

<hr id=ht>
<form action="/user/searchIndex">
<input type="submit" value="検索画面へ" />
</form>
<form action="/user/csv/csvIndex">
<input type="submit" value="CSV出力画面へ" />
</form>

<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>