<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">
	
		
<%--ここから下にコンテンツを挿入 --%>
検索前時間　：　${lastDate}
<h1>店舗検索</h1>
<input type="text" id="ajaxData"><input type="button" value="Ajax検索" id="ajaxSearch"/>

<div id="ajaxSe">
<c:import url="/WEB-INF/views/shop/search/ajaxSearch.jsp" charEncoding="UTF-8"/>
</div>
<input type="button" value="メニューに戻る" onclick="location.href='/user/top'"/>
<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>