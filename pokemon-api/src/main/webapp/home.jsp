<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

    <div class="container">
        <div class="card">
            <div class="div">
                <img src="${imageUrl}" alt="Image">
            </div>
            <div class="div">
                <p><%=session.getAttribute("name")%></p>
            </div>
            <div class="div">
                <p><%=session.getAttribute("id")%></p>
            </div>
            <div class="div">
                <form action="randomPokemon" method="post">
                    <input type="submit" value="RANDOM POKEMON">
                </form>
            </div>
        </div>
    </div>

</body>
</html>