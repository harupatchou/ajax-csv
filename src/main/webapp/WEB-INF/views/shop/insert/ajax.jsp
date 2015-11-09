<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- Ajax通信による登録 -->

登録後時間　：　${nowDate}

<h1>店舗一覧表示(Ajax確認用)</h1>

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

<form id="ajaxForm" onSubmit="return validation()">
<br>

<h2>登録フォーム</h2>
<table>
<tbody>
	<tr>
		<th>番号</th>
		<th>店舗名</th>
		<th>店舗住所</th>
		<th colspan='2'>店舗カテゴリ</th>
	</tr>
	<tr>
		<td rowspan='3' class='shopNo'><input type='hidden' name='no' class='shopNoHidden' /></td>
		<td><input name='name' size='20' id="shopName"/></td>
		<td><input name='address' size='20' id="shopAddress" /></td>
		<td id='cateText1'>選択したカテゴリ表示</td>
		<td>
			<input type='hidden' name='categoryName' id='cateHiddenName1' size='20' />
			<input type='hidden' name='categoryId' id='cateHiddenId1' />
			<input type='hidden' name='other' id='otherVal1' />
			<input type='button' value='カテゴリ選択' id='categoryBtn' onclick="return openWin('/shop/window?btnNo=1')" /></td>
	</tr>
	<tr>
		<th colspan='5'>店舗詳細</th>
	</tr>
	<tr>
		<td colspan='5'><textarea name='detail' rows='10' cols='75' id='shopDetail'></textarea></td>
	</tr>
</tbody>
</table>
<br>
</form>
