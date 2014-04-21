/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.actions;

import controleur.ActionServlet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
        String clientChoisi = requete.getParameter("choixClient");
        int idClientChoisi = Integer.parseInt (clientChoisi);
        Client unClient = service.ChercherClientParId(idClientChoisi);
        requete.setAttribute("clientChoisi", unClient);
    }
}