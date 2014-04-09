<%-- 
    Document   : index
    Created on : 2 avr. 2014, 15:37:03
    Author     : Administrateur
--%>

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
        <h1>Bonjour et veuillez vous connecter !</h1>
        <form action="http://localhost:8080/PredictifWeb/ActionServlet?todo=ConnectionEmploye" method="POST">
            <input type="text" id="login" name="login"/>
            <input type="submit" name="Validation" value="Ok"/>
        </form>
         
    </body>
</html>
