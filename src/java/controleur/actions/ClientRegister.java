/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.actions;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import predictif.Client;

/**
 *
 * @author alicia
 */
public class ClientRegister extends Action {
     @Override
    public void execute(HttpServletRequest requete) {
         
         //Récupération des informations du client 
         String civiliteClient = requete.getParameter("civility");
         String nomClient = requete.getParameter("name");
         String prenomClient = requete.getParameter("firstName");
         String mailClient = requete.getParameter("mailAdress");
         String adresseClient = requete.getParameter("postAdress");
         String naissanceClient = requete.getParameter("birthDate");
         int anneeClient = Integer.parseInt(naissanceClient.substring(0,3));
         int moisClient = Integer.parseInt(naissanceClient.substring(4,5));
         int jourClient = Integer.parseInt(naissanceClient.substring(6,7));
         String numeroClient = requete.getParameter("phone");
         String pub = requete.getParameter("commercial");
         String utilisation = requete.getParameter("utilisation");
         boolean publi=false;
         if (pub!=null)
         {
          publi = true;
         }
         
         Client myClient = null;
         if (utilisation != null)
         {
         myClient = new Client(publi,nomClient, prenomClient, civiliteClient, adresseClient, numeroClient, mailClient, anneeClient, moisClient, jourClient, null);          
         System.out.println(myClient.getNom());
         service.CreerClient(myClient);
         }
         Long idClient = myClient.getId();
         requete.getSession().setAttribute("idClient", idClient);
         requete.setAttribute("clientTreated", myClient);
         requete.setAttribute("serviceUsed", service);
         requete.setAttribute("conf", utilisation);
     }
    
}
