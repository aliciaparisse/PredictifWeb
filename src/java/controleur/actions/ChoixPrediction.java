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
public class ChoixPrediction extends Action
{

    @Override
    public void execute(HttpServletRequest requete) 
    {
        String forcePrediction = requete.getParameter("predictionAmourForce");
        if (forcePrediction != null)
        {
            int forceChoisiInt = Integer.parseInt (forcePrediction);
            // Service non fonctionnelle : requête SQL mal interprétée.
            List<Prediction> listPredict = service.ChercherPredictionParNiveau(forceChoisiInt);
            requete.setAttribute("listePredictAmour", listPredict);
        }
    }
    
}
