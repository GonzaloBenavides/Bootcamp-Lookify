<%@page import="org.springframework.ui.Model"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="cl.gonzalobenavides.lookifyapp.models.Song"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify! - Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/4f7f009016.js"
	crossorigin="anonymous"></script>

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col">
				<h1>Top Ten Songs</h1>
			</div>
			<div class="col">
				<a href="/dashboard">Dashboard</a>
			</div>
		</div>
		<div class="row">
			<table class="table table-striped mt-5 border border-1">
				<tbody>
					<c:forEach items="${lista}" var="song">
						<tr>
							<td><c:out value="${song.clasificacion}" /> - <a><c:out
										value="${song.titulo}" /></a> - <c:out value="${song.artista}" />
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>


</html>