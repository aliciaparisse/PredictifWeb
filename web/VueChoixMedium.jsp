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
        <link rel="stylesheet" href="style.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <span class="bannertext"> Prédict'IF...</span>
        </header>
       
        <section>
        <% Service monService = (Service) request.getAttribute("serviceUsed");
        Client monClient = (Client) request.getAttribute("clientTreated");
        String confirmation = (String) request.getAttribute("conf");  

        if (confirmation != null)
        {
                out.print("<form name=\"selectMedium\" action=\"http://localhost:8080/PredictifWeb/ActionServlet?todo=ChooseMedium\" method=\"POST\">");
                out.print("<h1>Choisissez un ou plusieurs de nos Mediums</h1>");
                out.print("<br>");
                out.print(" Astuce : cliquez sur l'avatar d'un medium pour découvrir son histoire et ses talents !");
                
                List <Medium> maListe = (List <Medium>) monService.ObtenirToutMedium();
                out.print(maListe.size());
                for (int i=0; i<5; i++)
                {
                    out.print("<br><a href=\"http://localhost:8080/PredictifWeb/ActionServlet?todo=DisplayMedium\" target=\"_blank\"><img src=\"img/Affiche" +i + ".jpg\" width=\"225\" height=\"318\" alt=\"AfficheJean\"/></a>");
                    out.print(maListe.get(i).getNom() + maListe.get(i).getTalent());
                    out.print("<input  type = \"checkbox\" name = \"medium\" " + i + " value = \"ON\"/>");
                }
                
                out.print("<input type=\"submit\" value=\"J'ai choisi !\" name=\"toSelect\" />");
                out.print("</form>");

        }
        else
        {
            out.print("Vous n'avez pas accepté les conditions d'utilisations ! ");
            out.print("<br>");
            out.print("<a href = \"InscriptionPageClient.jsp\" > Retour vers l'inscription</a>");
        }
        %>
        </section>
    </body>
</html>
