/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controleur.actions;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import predictif.Prediction;
import predictif.PredictionAmour;

/**
 *
 * @author Jean
 */
public class CreationHoroscope extends Action
{

    @Override
    public void execute(HttpServletRequest requete) 
    {
        HttpSession session = (HttpSession) requete.getAttribute("sessionOuverte");
        
        String referencePredictionAmour= requete.getParameter("predictionAmourReference");
        String referencePredictionSante= requete.getParameter("predictionSanteReference");
        String referencePredictionTravail= requete.getParameter("predictionTravailReference");
        if (referencePredictionAmour != null)
        {
            int predictionAmourId = Integer.parseInt (referencePredictionAmour);
            
            Prediction predictionAmourChoisie = service.ChercherPredictionParId(predictionAmourId);
            String textePredictionChoisie = predictionAmourChoisie.getTexte();
            session.setAttribute("predictionAmourChoisie", predictionAmourChoisie);
            requete.setAttribute("corpsHo", textePredictionChoisie);
        }
        if (referencePredictionSante != null)
        {
            int predictionSanteId = Integer.parseInt (referencePredictionSante);
            
            Prediction predictionSanteChoisie = service.ChercherPredictionParId(predictionSanteId);
            String textePredictionChoisie = predictionSanteChoisie.getTexte();
            session.setAttribute("predictionSanteChoisie", predictionSanteChoisie);
            requete.setAttribute("corpsHo", textePredictionChoisie);
        }
        if (referencePredictionTravail != null)
        {
            int predictionTravailId = Integer.parseInt (referencePredictionTravail);
            
            Prediction predictionTravailChoisie = service.ChercherPredictionParId(predictionTravailId);
            String textePredictionChoisie = predictionTravailChoisie.getTexte();
            session.setAttribute("predictionTravailChoisie", predictionTravailChoisie);
            requete.setAttribute("corpsHo", textePredictionChoisie);
        }
    }
    
}
