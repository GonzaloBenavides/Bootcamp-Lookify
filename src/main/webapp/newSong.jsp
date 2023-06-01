<%@page import="org.springframework.ui.Model"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="cl.gonzalobenavides.lookifyapp.models.Song"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lookify! - New Song</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="col-ms-12">
			<a href="/dashboard">Dashboard</a>
			<h1>NEW SONG</h1>
			<form:form action="/songs/new" method="post" modelAttribute="song">
				<div class="row mb-3">
					<form:errors class="text-danger" path="titulo" />
					<form:errors class="text-danger" path="artista" />
					<form:errors class="text-danger" path="clasificacion" />
				</div>
				<div class="form-outline mb-4">
					<form:input class="form-control" type="text" path="titulo" id="titulo" />
					<form:label class="form-label" for="titulo" path="titulo">Title</form:label>
				</div>
				<div class="form-outline mb-4">
					<form:input class="form-control" type="text" path="artista" id="artista" />
					<form:label class="form-label" path="artista">Artist</form:label>
				</div>
				<div class="form-outline mb-4">
					<form:input class="form-control" type="number" path="clasificacion" id="clasificacion" />
					<form:label class="form-label" path="clasificacion">Rating(1-10)</form:label>
				</div>
				<div>
					<input type="submit" class="btn btn-primary" value="Crear" />
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>