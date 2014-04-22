/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controleur.actions;

import java.util.ArrayList;
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
        String forcePredictionAmour = requete.getParameter("predictionAmourForce");
        String forcePredictionSante = requete.getParameter("predictionSanteForce");
        String forcePredictionTravail = requete.getParameter("predictionTravailForce");
        if (forcePredictionAmour != null)
        {
            int forceChoisiInt = Integer.parseInt (forcePredictionAmour);
            
            Prediction predictionChoisie = service.ChercherPredictionParId(350);
            List<Prediction> listPredict = new ArrayList<Prediction>();
            listPredict.add(predictionChoisie);
            requete.setAttribute("listePredictAmour", listPredict);
            /*
            // Service non fonctionnelle : requête SQL mal interprétée.
            List<Prediction> listPredict = service.ChercherPredictionParNiveau(forceChoisiInt);
            if (listPredict != null)
            {
            for (int i=0; i<listPredict.size();i++)
                System.out.println(listPredict.get(i).getId());
            }
            else
                System.out.println("liste nulle");
            List<Prediction> listePredict = service.ChercherPredictionParType(PredictionAmour.class);
            if (listePredict != null)
            {
            for (int i=0; i<listePredict.size();i++)
                System.out.println(listePredict.get(i).getId());
            }
            else
                System.out.println("liste 2 nulle");
            
            
            //requete.setAttribute("listePredictAmour", listPredict);*/
        }
        if (forcePredictionSante != null)
        {
            int forceChoisiInt = Integer.parseInt (forcePredictionSante);
            
            Prediction predictionChoisie = service.ChercherPredictionParId(210);
            List<Prediction> listPredict = new ArrayList<Prediction>();
            listPredict.add(predictionChoisie);
            requete.setAttribute("listePredictSante", listPredict);
        }
        
        if (forcePredictionTravail != null)
        {
            int forceChoisiInt = Integer.parseInt (forcePredictionTravail);
            
            Prediction predictionChoisie = service.ChercherPredictionParId(60);
            List<Prediction> listPredict = new ArrayList<Prediction>();
            listPredict.add(predictionChoisie);
            requete.setAttribute("listePredictTravail", listPredict);
        }
    }
    
}
