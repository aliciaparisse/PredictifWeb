/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controleur.actions;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
        String referencePredictionAmour= requete.getParameter("predictionAmourReference");
        if (referencePredictionAmour != null)
        {
            int predictionAmourId = Integer.parseInt (referencePredictionAmour);
            Prediction predictionAmourChoisie = service.ChercherPredictionParId(predictionAmourId);
            String textePredictionChoisie = predictionAmourChoisie.getTexte();
            requete.setAttribute("predictionAmourChoisie", predictionAmourChoisie);
            requete.setAttribute("corpsHo", textePredictionChoisie);
        }
    }
    
}
