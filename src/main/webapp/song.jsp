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
	<title>Lookify! - Song</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<a href="/dashboard">Dashboard</a>
		</div>
		<div class="row">
			<div class="col">
				Title
			</div>
			<div class="col">
				${song.titulo}
			</div>
		</div>
		<div class="row">
			<div class="col">
				Artist
			</div>
			<div class="col">
				${song.artista}
			</div>
		</div>
		<div class="row">
			<div class="col">
				Rating (1-10)
			</div>
			<div class="col">
				${song.clasificacion}
			</div>
		</div>
		<div class="row">
			<div class="col">
				<a href="/songs/delete/${song.id}">Delete</a>
			</div>
		</div>
		
	</div>
</body>
</html>