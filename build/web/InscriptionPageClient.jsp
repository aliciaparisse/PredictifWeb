<%-- 
    Document   : InscriptionPageClient
    Created on : 16 avr. 2014, 14:23:17
    Author     : alicia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="style.css" />
        <title>Inscription Page Client</title>
    </head>
    <body>..
        <header>
            <span class="bannertext"> Prédict'IF...</span>
        </header>
        <h1>Inscription</h1> 
        <br>
        <form action="http://localhost:8080/PredictifWeb/ActionServlet?todo=InscriptionClient" method="POST">
        <section>
        
            <select name="civility">
                <option>Mme </option>
                <option>Melle</option>
                <option>Mr</option>
            </select>
            
            <span class="formulaire">Nom :<input type="text" name="name" value="" size="30" /><br> </span>
            <span class="formulaire">Prénom :<input type="text" name ="firstName"  value="" size="30" /><br></span>
            <span class="formulaire">Adresse mail :<input type="text" name="mailAdress"  value="" size="50" /><br></span>
            <span class="formulaire">Adresse Postale<textarea name ="postAdress"  rows="4" cols="30">
                </textarea><br></span>
            Date de Naissance(Format aaaammjj) : <input type="text" name ="birthDate"  value="" size="30" /><br>
            Téléphone :<input type="text" name ="phone"  value="" size="30" /><br>
            <input type="checkbox" name ="commercial" value="ON" checked="checked"/> J'accepte de recevoir des offres de nos partenaires commerciaux<br>
            <input type="checkbox" name ="utilisation"  value="ON" checked="checked" /> J'accepte les conditions d'utilisations de ce service
            <input type="submit" value="Etape suivante" name="registerInBdd" />
        
        </section>
        
        </form>
    </body>
</html>
