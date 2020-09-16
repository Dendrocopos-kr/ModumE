<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/res/css/common.css">
<title>${title}</title>
</head>
<body>
	<div id="container">
		<header id="header">
			<jsp:include page="/WEB-INF/view/${topView}.jsp"></jsp:include>
		</header>
		<section id="container">
			<jsp:include page="/WEB-INF/view/${view}.jsp"></jsp:include>
		</section>
		<footer id="footer">
			<jsp:include page="/WEB-INF/view/${bottomView}.jsp"></jsp:include>
		</footer>
	</div>
</body>
</html>