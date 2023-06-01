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
				<a href="/dashboard">Dashboard</a>
			</div>
			<div class="col">
				<p>Songs by artist: ${artista}</p>
			</div>
			<div class="col">
				<div class="container">
					<form:form modelAttribute="newArtista" action="/search">
						<div class="row">
							<div class="col">
								<form:errors class="text-danger" path="artista" />
								<form:input class="form-control" type="text" path="artista" />
							</div>
							<div class="col">
								<form:button class="btn btn-secondary">New Search</form:button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
			
		</div>
		<div class="row">
			<table class="table table-striped mt-5 border border-1">
				<thead>
					<tr>
						<th>Name</th>
						<th>Artist</th>
						<th>Rating</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${lista}" var="song">
						<tr>
							<td><a href="#"> <c:out value="${song.titulo}"></c:out>
							</a></td>
							<td><c:out value="${song.artista}"></c:out></td>
							<td><c:out value="${song.clasificacion}"></c:out></td>
							<td><a href="/song/delete/${song.id}"> <i
									class="fa-solid fa-trash" style="color: #000000;"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>


</html>