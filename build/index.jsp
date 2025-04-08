<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <%-- <link rel="stylesheet" href="css/style.css"> --%>
</head>
<body>
    <div class="container">
        <h3>Connexion</h3>
        <% if(request.getAttribute("erreur") != null) { %>
            <p style="color: red;"><%= request.getAttribute("erreur") %></p>
        <% } %>
        <form action="LoginServlet" method="post">
            <div>
                <label for="nom">Votre nom :</label>
                <input type="text" name="nom" id="nom" placeholder="nom" required>
            </div>
            <div>
                <label for="mdp">Votre mot de passe :</label>
                <input type="password" name="mdp" id="mdp" placeholder="nom" required>
            </div>
            <button type="submit">Envoyer</button>
        </form>
    </div>
</body>
</html>