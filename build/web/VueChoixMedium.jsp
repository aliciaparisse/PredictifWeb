<%-- 
    Document   : VueChoixMedium
    Created on : 16 avr. 2014, 14:58:10
    Author     : alicia
--%>

<%@page import="predictif.Client"%>
<%@page import="predictif.Medium"%>
<%@page import="java.util.List"%>
<%@page import="predictif.service.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="selectMedium" action="http://localhost:8080/PredictifWeb/ActionServlet?todo=ChooseMedium" method="POST">
        
        <h1>Choisissez un ou plusieurs de nos Mediums</h1>
        Astuce : cliquez sur l'avatar d'un medium pour découvrir son histoire et ses talents !
        
       
        
        <% Service monService = (Service) request.getAttribute("serviceUsed");
        Client monClient = (Client) request.getAttribute("clientTreated");
        List <Medium> maListe = (List <Medium>) monService.ObtenirToutMedium();
        out.print(maListe.size());
        for (int i=0; i<5; i++)
        {
            out.print("<br><a href=\"http://localhost:8080/PredictifWeb/ActionServlet?todo=DisplayMedium\" target=\"_blank\"><img src=\"img/Affiche" +i + ".jpg\" width=\"225\" height=\"318\" alt=\"AfficheJean\"/></a>");
            out.print(maListe.get(i).getNom() + maListe.get(i).getTalent());
            out.print("<input  type = \"checkbox\" name = \"medium\" " + i + " value = \"ON\"/>");
        }
        %>
        <input type="submit" value="J'ai choisi !" name="toSelect" />
        </form>
    </body>
</html>
