<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter une prévision</title>
    <%-- <link rel="stylesheet" href="css/style.css"> --%>
</head>
<body>
    <h3>Ajouter une prévision budgetaire</h3>
    <% if(request.getAttribute("erreur") != null) { %>
        <p style="color: red;"><%= request.getAttribute("erreur") %></p>
    <% } %>
    <form action="PrevisionServlet" method="post">
        <div>
            <label for="libelle">Nom du libellé :</label>
            <input type="text" id="libelle" name="libelle" required>
        </div>
        <div>
            <label for="montant">Montant :</label>
            <input type="number" id="montant" name="montant" required>
        </div>
        <button type="submit">Valider</button>
        <a href="ajoutDepense.jsp">Ajouter une depense</a>
    </form>
</body>
</html>