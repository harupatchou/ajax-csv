<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="/js/windowsOpen.js"></script>
<title>Insert title here</title>
</head>
<body>
<form>
<h1>カテゴリ選択</h1>
<c:forEach var="category" items="${categoryList}">
<p>
<label>
<input type="checkbox" name="category" value="${category.name}"><c:out value="${category.name}"/>
<input type="hidden" name="categoryId" value="${category.id}">
<c:if test="${category.id == 100}"><input type="text" name="categoryOther" id="categoryOther"></c:if>
</label>
</p>
</c:forEach>
<p><input type="button" value="選択完了" onclick="goBackCategory(${btnNo});"></p>
</form>
</body>
</html>