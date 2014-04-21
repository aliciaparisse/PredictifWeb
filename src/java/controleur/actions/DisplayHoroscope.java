/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controleur.actions;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import predictif.Client;
import predictif.Horoscope;

/**
 *
 * @author Jean
 */
public class DisplayHoroscope extends Action
{
    private List<Horoscope> listHoroscope;
    private int positionCourante;
    
    @Override
    public void execute(HttpServletRequest requete) 
    {
        // Récupération de la session courante et du client en cours de traitement
        HttpSession session = (HttpSession) requete.getAttribute("sessionOuverte");
        Client clientTraite = (Client) session.getAttribute("leClient");
        
        // Récupérer liste Horoscope et afficher le dernier de la liste
        listHoroscope = clientTraite.getHoroscopePrecedent();
        Horoscope dernierHo;
        String corpsHoroscope;
        if (!listHoroscope.isEmpty())
        {
            positionCourante = listHoroscope.size()-1;
            dernierHo = listHoroscope.get(positionCourante);
            corpsHoroscope = dernierHo.CorpsHoroscope();
        }
        else
            corpsHoroscope = "Ce client ne possède pas encore d'horoscope.";
        requete.setAttribute("corpsHo", corpsHoroscope);
        
        // Débloquer bouton suivant et/ou précédent si possible
        String hoSuivant = suivantPossible();
        requete.setAttribute("allowSuivant", hoSuivant);
        String hoPrecedent = precedentPossible();
        requete.setAttribute("allowPrecedent", hoPrecedent);
        
    }
    
    /**
     * Affiche l'horoscope suivant dans la liste des horoscopes du client
     * en cours
     * @param requete 
     */
    public void afficherHoSuivant (HttpServletRequest requete)
    {
        // Récupération du corps de l'horoscope suivant
        Horoscope hoSuivant = listHoroscope.get(++positionCourante);
        String corpsHoroscope = hoSuivant.CorpsHoroscope();
        requete.setAttribute("corpsHo", corpsHoroscope);
        
        // Débloquer bouton suivant ou précédent si possible
        String hoSuivantPo = suivantPossible();
        requete.setAttribute("allowSuivant", hoSuivantPo);
        String hoPrecedentPo = precedentPossible();
        requete.setAttribute("allowPrecedent", hoPrecedentPo);
    }
    
    /**
     * Affiche l'horoscope précédent dans la liste des horoscopes du
     * client en cours
     * @param requete 
     */
    public void afficherHoPrecedent (HttpServletRequest requete)
    {
        // Récupération du corps de l'horoscope précédent
        Horoscope hoPrecedent = listHoroscope.get(--positionCourante);
        String corpsHoroscope = hoPrecedent.CorpsHoroscope();
        requete.setAttribute("corpsHo", corpsHoroscope);
        
        // Débloquer bouton suivant ou précédent si possible
        String hoSuivantPo = suivantPossible();
        requete.setAttribute("allowSuivant", hoSuivantPo);
        String hoPrecedentPo = precedentPossible();
        requete.setAttribute("allowPrecedent", hoPrecedentPo);
    }
    
    /**
     * Vérifie s'il est possible d'accéder à l'horoscope suivant
     * @return 
     */
    public String suivantPossible ()
    {
        String possible = null;
        if (positionCourante < listHoroscope.size()-1)
            possible = "oui";
        return possible;
    }
    
    /**
     * Vérifie s'il est possible d'accéder à l'horoscope précédent
     * @return 
     */
    public String precedentPossible ()
    {
        String possible = null;
        if (positionCourante > 1)
            possible = "oui";
        return possible;
    }
    
}
