<%-- 
    Document   : VueLogInEmploye
    Created on : 2 avr. 2014, 15:37:03
    Author     : Administrateur
--%>

<%@page import="predictif.Employé"%>
<%@page import="predictif.Client"%>
<%@page import="predictif.service.Service"%>
<%@page import="predictif.Medium"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenue sur Predict'IF</title>
    </head>
    <body>
        <h1>Bonjour ! <br> Veuillez vous connecter !</h1>
        
        <form action="ActionServlet?todo=ConnectionEmploye" method="POST"/>    
            <input type="text" name="login"/>
            <input type="submit" name="Validation" value="Ok"/>
        </form>
        
        <form action="ActionServlet?todo=TraiterClient" method="POST">
            <table>
                <caption>Liste des clients</caption>
                <tr>
                    <th>Nom</th>
                    <th>Prénom</th>
                </tr>
        <%
            if (session.getAttribute("user") != null)
            {
                if(session.getAttribute("listeClient") != null) 
                {
                    List<Client> listClient = (List<Client>) session.getAttribute("listeClient");
                    for (int i=0; i < listClient.size(); i++)
                    {
                        out.print("<tr>");
                        out.print("<th>" + "<input type=\"radio\" name=\"choixClient\" value=\"" + listClient.get(i).getId() + "\"/> " + listClient.get(i).getNom() + "</th>");
                        out.print("<th>" + listClient.get(i).getPrenom() + "</th>");                    
                        out.print("</tr>");
                    }
                }
            }
            else
            {
                if (request.getAttribute("employeExiste") == "oui")
                {
                    if(session.getAttribute("listeClient") != null) 
                    {
                        List<Client> listClient = (List<Client>) session.getAttribute("listeClient");
                        for (int i=0; i < listClient.size(); i++)
                        {
                            out.print("<tr>");
                            out.print("<th>" + "<input type=\"radio\" name=\"choixClient\" value=\"" + listClient.get(i).getId() + "\"/> " + listClient.get(i).getNom() + "</th>");
                            out.print("<th>" + listClient.get(i).getPrenom() + "</th>");                    
                            out.print("</tr>");
                        }
                    }
                }
                else if (request.getAttribute("employeExiste") == "non")
                    out.print("Veuillez rentrer un identifiant correct");
            }
        %>            
            </table>
        <%
            if (request.getAttribute("clientCoché") != null)
            {
                String unchecked = (String) request.getAttribute("clientCoché");
                if (unchecked.equals("incorrect"))
                    out.print("Veuillez sélectionner un client.");
            }
        %>
            <input type="submit"  name="traitement" value="Traiter"/>
        </form>
         
    </body>
</html>
