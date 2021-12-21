<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 TODOLIST</title>
<link href="${rootPath}/static/css/todolist.css?ver=2021-12-03-002"
	rel="stylesheet" />
<link href="${rootPath}/static/css/todoInput.css?ver=2021-12-03-002"
	rel="stylesheet" />
<link href="${rootPath}/static/css/todoItem.css?ver=2021-12-03-002"
	rel="stylesheet" />
</head>
<body>
	<main class="todo-list-template">
		<div class="title">TODOLIST</div>
		<section class="form-wrapper">입력창</section>
		<%@ include file="/WEB-INF/views/todoInput.jsp"%>
		<section class="todos-wrapper">
			<%@ include file="/WEB-INF/views/todoList.jsp"%>
		</section>
	</main>
	<!-- <c:if test="${ not empty IMAGES['SAVENAME']  }"> -->
		<p>
			<img id="imgView" width="100px" src="${rootPath}/files/${IMAGES['SAVENAME']}">
	<!-- </c:if> -->
</body>
</html>