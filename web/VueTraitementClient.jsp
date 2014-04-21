<%-- 
    Document   : VueTraitementEmp
    Created on : 16 avr. 2014, 15:45:01
    Author     : Administrateur
--%>

<%@page import="predictif.Horoscope"%>
<%@page import="predictif.Medium"%>
<%@page import="java.util.List"%>
<%@page import="predictif.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Informations client</h3>
        <form action="ActionServlet?todo=AfficherDernierHoroscope" method="POST">
            <p>
                <%
                    // Récupération du client en cours de traitement
                    Client clientTraite = (Client) session.getAttribute("leClient");
                %>

                Nom: <input type="text" name="nomClient" value="<%out.print(clientTraite.getNom());%>"/> 

                Référence: <input type="text" name="reference" value="<%out.print(clientTraite.getReferent().getLogin());%>"/>

                <br> Prénom: <input type="text" name="prenomClient" value="<%out.print(clientTraite.getPrenom());%>"/>

                <br> Signe Astro: <input type="text" name="signeAstroClient" value="<%out.print(clientTraite.getSigneAstro().getNom());%>"/>

                <br> Nombre d'horoscope: <input type="text" name="nbHoroscopeClient" value="<%out.print(clientTraite.getHoroscopePrecedent().size());%>"/>

            </p>
            <p>
                <input type="submit" name="tousHoroscopePrécédent" value="Afficher les horoscopes précédents"/>
            </p>
        </form>
        
        <h3>Construction de l'horoscope</h3>
        <p> 
            Choix du médium: 
            <select name="selectMedium" size="nbMedium">
                <%
                    // Affiche la liste des médiums préférés du client en cours de traitement
                    List<Medium> listMediums = clientTraite.getMediumPreferes();
                    for (int i=0; i<listMediums.size();i++)
                    {
                %>
                <option value="<%out.print(listMediums.get(i).getNom());%>"><%out.print(listMediums.get(i).getNom());%></option>
                <%}%>
            </select>
        </p>
        <!--
        <p>
            <!-- Non pris en compte par les services donc on laisse de côté >
            Prédiction Travail: </br>
           <select name="predictionTravailForce" size="nbForceTravail"></select>
             <select name="predictionTravailReference" size="nbReferenceTravail"></select>
             <input type="submit" name="affichage" value="Afficher"/>
        </p>
        -->
        <p>
            Prédiction Amour: <br>
           <select name="predictionAmourForce" size="nbForceAmour"></select>
             <select name="predictionAmourReference" size="nbReferenceAmour"></select>
             <input type="submit" name="affichage" value="Afficher"/>
        </p>
        <p>
            Prédiction Sante: <br>
           <select name="predictionSanteForce" size="nbForceSante"></select>
             <select name="predictionSanteReference" size="nbReferenceSante"></select>
             <input type="submit" name="affichage" value="Afficher"/>
        </p>
        
        <p> 
            <input type="submit" name="AfficherMail" value="Afficher le mail"/>
        </p>
        
        <div>
            <textarea name="zoneAffichage" cols="40" row="20">
                <%
                    // Récupération du corps de l'horoscope à afficher
                    if (request.getAttribute("corpsHo") != null)
                        out.print((String) request.getAttribute("corpsHo"));                            
                %>
            </textarea>
            
            <form action="ActionServlet?todo=HoroscopePrecedent" method="POST">
                <%   
                    // On désactive le bouton s'il n'est pas utilisable pour la suite
                    if (request.getAttribute("allowPrecedent") != null)
                    {
                        if (request.getAttribute("allowPrecedent").equals("oui"))
                            out.print("<input type=\"submit\" name=\"horoscopePrecedent\" value=\"Précédent\"/>");
                        else
                            out.print("<input type=\"submit\" name=\"horoscopePrecedent\" value=\"Précédent\" disabled/>");
                    }
                    else
                        out.print("<input type=\"submit\" name=\"horoscopePrecedent\" value=\"Précédent\" disabled");
                %>
            </form>
            
            <form action="ActionServlet?todo=HoroscopeSuivant" method="POST">
                <%   
                    // On désactive le bouton s'il n'est pas utilisable pour la suite
                    if (request.getAttribute("allowSuivant") != null)
                    {
                        if (request.getAttribute("allowPrecedent").equals("oui"))
                            out.print("<input type=\"submit\" name=\"horoscopeSuivant\" value=\"Précédent\"/>");
                        else
                            out.print("<input type=\"submit\" name=\"horoscopeSuivant\" value=\"Précédent\" disabled/>");
                    }
                    else
                        out.print("<input type=\"submit\" name=\"horoscopeSuivant\" value=\"Précédent\" disabled");
                %>
            </form>
            
        </div>
        
        <form action="ActionServlet?todo=EnvoyerMail" method="POST">
            <input type="submit" name="mailClient" value ="Envoyer"/>
        </form>
    </body>
</html>
