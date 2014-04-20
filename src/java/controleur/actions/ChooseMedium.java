/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.actions;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import predictif.Client;
import predictif.Medium;

/**
 *
 * @author alicia
 */
public class ChooseMedium extends Action {
    
    @Override
    public void execute(HttpServletRequest requete) {
        //List <String> mediums = null;
        String nomClient = requete.getParameter("name");
        List <Medium> tousLesMediums = (List <Medium>) service.ObtenirToutMedium();
        List <Medium> mediumsClient = null;
        for (int i = 0; i < 5 ; i++)
        {
            String medium = requete.getParameter("medium"+i);
            if (medium != null)
            {
                mediumsClient.add(tousLesMediums.get(i));
            }
        }
        Client monClient = service.ChercherClientParNom(nomClient).get(1);
        requete.setAttribute("serviceUsed", service);
    }
    
}
