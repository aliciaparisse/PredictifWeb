/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.actions;

import controleur.ActionServlet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import predictif.Client;
import predictif.Employé;

/**
 *
 * @author Administrateur
 */
public class TraitementClient extends Action 
{
    @Override
    public void execute(HttpServletRequest requete) 
    {
        // Récupération du client sélectionné par les boutons radio
        String clientChoisi = requete.getParameter("choixClient");
        if (clientChoisi != null)
        {
            int idClientChoisi = Integer.parseInt (clientChoisi);
            Client unClient = service.ChercherClientParId(idClientChoisi);

            // Récupération de la session en cours et enregistrement de ce client sur la session
            HttpSession session = (HttpSession) requete.getAttribute("sessionOuverte");
            session.setAttribute("leClient", unClient);
        }
    }
}