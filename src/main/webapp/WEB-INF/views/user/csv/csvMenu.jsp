<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">
	
		
<%--ここから下にコンテンツを挿入 --%>

<h1>CSV出力画面</h1>

<form action="/user/csv/download">
<input type="submit" value="ダウンロード" />
</form>
<br>
<form:form action="/user/csv/upload" modelAttribute="mainForm">
<input type="submit" value="アップロード" />
<input type="file" name="csvFile" />
</form:form>
<br>
<form action="/user/top">
<input type="submit" value="topへ戻る" />
</form>


<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>
