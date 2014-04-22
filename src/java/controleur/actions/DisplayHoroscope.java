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
import predictif.Medium;
import predictif.Prediction;
import predictif.PredictionAmour;
import predictif.PredictionSante;
import predictif.PredictionTravail;

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
     * Crée un horoscope à partir des données choisies par l'employé sur sa 
     * page de traitement du client
     * @param requete 
     */
    public void afficherHoroscopeCree (HttpServletRequest requete)
    {
        HttpSession session = (HttpSession) requete.getAttribute("sessionOuverte");
        String corpsNewHo;
        
        if (session.getAttribute("predictionAmourChoisie") != null && session.getAttribute("predictionSanteChoisie") != null && session.getAttribute("predictionTravailChoisie") != null)
        {            
            // Récupération des éléments qui vont composer le nouvel horoscope : prédictions, médium et client
            Prediction predictionAmour = (Prediction) session.getAttribute("predictionAmourChoisie");
            Prediction predictionSante = (Prediction) session.getAttribute("predictionSanteChoisie");
            Prediction predictionTravail = (Prediction) session.getAttribute("predictionTravailChoisie");
            if (requete.getParameter("selectMedium") != null)
            {
                String nomMedium = (String) requete.getParameter("selectMedium");
                Medium leMedium = service.ChercherMedium(nomMedium);
                Client leClient = (Client) session.getAttribute("leClient");
                
                // Création de l'horoscope
                Horoscope newHoroscope = new Horoscope (leClient, leMedium, (PredictionAmour) predictionAmour, (PredictionSante) predictionSante, (PredictionTravail) predictionTravail);
                session.setAttribute("nouvelHoroscope", newHoroscope);
                
                // récupération du corps de l'horoscope
                corpsNewHo = newHoroscope.CorpsHoroscope();
            }
            else
                corpsNewHo = "Veuillez sélectionner un médium avant de créer votre horoscope !";
        }
        else
            corpsNewHo = "Veuillez sélectionner une prédiction pour chaque élément avant de créer votre horoscope !";
        requete.setAttribute("corpsHo", corpsNewHo);
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
        if (positionCourante > 0)
            possible = "oui";
        return possible;
    }
    
}
