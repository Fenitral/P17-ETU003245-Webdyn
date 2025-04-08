<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, models.Prevision" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter une dépense</title>
    <%-- <link rel="stylesheet" href="css/style.css"> --%>
    
</head>
<body>
    <h3>Ajouter une dépense</h3>
    <% if(request.getAttribute("erreur") != null) { %>
        <p style="color: red;"><%= request.getAttribute("erreur") %></p>
    <% } %>
    <form action="DepenseServlet" method="post">
        <div>
            <label for="libelle">Nom du libellé :</label>
            <select id="libelle" name="idPrevision" required>
                <option value="">Sélectionnez un libellé</option>
                <% 
                    List<Prevision> previsions = (List<Prevision>) request.getAttribute("previsions");
                    if(previsions == null) {
                        out.println("<option value=''>Erreur : previsions est null</option>");
                    } else if(previsions.isEmpty()) {
                        out.println("<option value=''>Aucune prévision disponible</option>");
                    } else {
                        for(Prevision p : previsions) {
                %>
                    <option value="<%= p.getId() %>"><%= p.getNom() %> (Budget: <%= p.getMontant() %>)</option>
                <% 
                        }
                    }
                %>
            </select>
        </div>
        <div>
            <label for="montant">Montant :</label>
            <input type="number" id="montant" name="montant" required>
        </div>
        <button type="submit">Ajouter</button>
    </form>
    <a href="DashboardServlet">Voir toutes les dépenses</a>
</body>
</html>