<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<c:forEach items="${pokemons}" var="pokemon">
			<div class="card">
				<img src="${pokemon.getSprites().getFrontDefault()}"/>
				<div class="detail">
					<c:out value="${pokemon.id}" />
					<c:out value="${pokemon.name}" />
					<form action="myPokemons" method="post">
					    <input type="hidden" name="pokemonId" value="${pokemon.id}">
						<input type="submit" value="DELETE">
					</form>
				</div>
			</div>								
		</c:forEach>
	</div>
</body>
</html>