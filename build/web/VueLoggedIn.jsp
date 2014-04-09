<%-- 
    Document   : VueLoggedIn
    Created on : 9 avr. 2014, 16:51:58
    Author     : alicia
--%>

<%@page import="predictif.Employé"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% Employé employe = (Employé) request.getAttribute("EmployeById");
        if (employe == null)
        {
            out.println ("Vous n'existez pas ! Vous êtes dans la matrice Muhahaha");
        }
        else
        {
            out.println(employe.getLogin());
        }%>
        <a  href = "index.jsp" > Retour à l'accueil</a>
    </body>
</html>
