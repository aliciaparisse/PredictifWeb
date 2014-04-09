<%-- 
    Document   : VueListeMedium
    Created on : 9 avr. 2014, 15:06:05
    Author     : alicia
--%>

<%@page import="predictif.Medium"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% List<Medium> liste = (List<Medium>)request.getAttribute("listeMedium");
        for (Medium m : liste)
        {
                out.println(m.getNom() + "<p>");
        }%>
    </body>
</html>
