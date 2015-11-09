<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">
	
		
<%--ここから下にコンテンツを挿入 --%>
<h1>店舗登録</h1>

<div id="errorArea">
<table id="errorList">
<tr>
</tr>
</table>
</div>

<br><hr>
<form:form modelAttribute="shopsForm" action="/shop/insert" name="shopInsert" onSubmit="return validation()">
<span id="errorMsg" ></span>
<input type="button" value="行追加" onclick="addShop('addShop')" />
<table border="1" id="addShop">
</table>

<input type="submit" value="登録内容確認"/>
</form:form>
<br>
<input type="button" value="メニューに戻る" onclick="location.href='/user/top'"/>
<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>