<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, models.Prevision, models.Depense" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tableau de bord des dépenses</title>
    <%-- <link rel="stylesheet" href="css/style.css"> --%>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid black; padding: 8px; text-align: left; }
    </style>
</head>
<body>
    <h3>Tableau de bord des dépenses</h3>
    <table>
        <tr>
            <th>Nom du libellé</th>
            <th>Montant (Somme des dépenses)</th>
            <th>Reste</th>
        </tr>
        <% 
            List<Prevision> previsions = (List<Prevision>) request.getAttribute("previsions");
            List<Depense> depenses = (List<Depense>) request.getAttribute("depenses");
            if(previsions != null && depenses != null) {
                for(Prevision p : previsions) {
                    int sommeDepenses = 0;
                    for(Depense d : depenses) {
                        if(d.getIdPrevision() == p.getId()) {
                            sommeDepenses += d.getMontant();
                        }
                    }
                    int reste = p.getMontant() - sommeDepenses;
        %>
            <tr>
                <td><%= p.getNom() %></td>
                <td><%= sommeDepenses %></td>
                <td><%= reste %></td>
            </tr>
        <% 
                }
            }
        %>
    </table>
    <a href="ajoutPrevision.jsp">Ajouter une nouvelle prévision</a>
</body>
</html>