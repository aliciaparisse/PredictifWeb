/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controleur.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import predictif.Client;
import predictif.Horoscope;

/**
 *
 * @author Jean
 */
public class EnvoieMail extends Action 
{

    @Override
    public void execute(HttpServletRequest requete) 
    {
        HttpSession session = (HttpSession) requete.getAttribute("sessionOuverte");
        
        if (requete.getAttribute("nouvelHoroscope") != null)
        {
            // Récupération du nouvel Horoscope associé au client
            Horoscope newHoroscope = (Horoscope) requete.getAttribute("nouvelHoroscope");
            
            // Récupération du client traité
            Client leClient = (Client) session.getAttribute("leClient");
            
            // Ligne inutile, juste du RP vu qu'on est censé envoyer un mail ^^
            String mailClient = leClient.getMail();
            
            service.CreerHoroscope(newHoroscope);
        }
    }
    
}
