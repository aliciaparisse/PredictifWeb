<%-- 
    Document   : VueChoixMedium
    Created on : 16 avr. 2014, 14:58:10
    Author     : alicia
--%>

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
        <h1>Vous devez maintenant choisir votre medium</h1>
        <br><a href="http://localhost:8080/PredictifWeb/VueMediumX.jsp"><img src="img/AfficheJean.jpg" width="225" height="318" alt="AfficheJean"/></a>
        <br><input type="checkbox" name="JeanMarchal" value="ON" />Jean Marchal
        <% Service monService = (Service) request.getAttribute("serviceUsed");
        
        List <Medium> maListe = (List <Medium>) monService.ObtenirToutMedium();
        for (int i=0; i<5; i++)
        {
            out.print("<br><a href=\"http://localhost:8080/PredictifWeb/VueMediumX.jsp\"><img src=\"img/Affiche" +i + ".jpg\" width=\"225\" height=\"318\" alt=\"AfficheJean\"/></a>");
            out.print(maListe.get(i).getNom() + maListe.get(i).getTalent());
            out.print("<input  type = \"checkbox\" name = \"medium\" value = \"ON\"/>");
        }
        %>
    </body>
</html>
