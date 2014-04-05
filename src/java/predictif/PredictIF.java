/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif;

import Simulation.LectureDonneesCsv;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import predictif.DAO.JPAutil;
import predictif.service.Service;
import Simulation.Saisie;

/**
 *
 * @author Administrateur
 */
public class PredictIF {

    /**
     * @param args the command line arguments
     */
    
    public static void InteractiveClient ()
    {
        Service service = new Service();
        Saisie saisie = new Saisie();
         
        String nom = saisie.lireChaine("Entrez votre Nom");
        String prenom = saisie.lireChaine("Entrez votre Preom");
        String civilité = saisie.lireChaine("Civilité");
        String adresse = saisie.lireChaine("Entrez votre Adresse");
        String numero = saisie.lireChaine("Entrez votre numero");
        Integer jour;
        jour = saisie.lireInteger("Entrez votre mois de naissance");
        
        Integer mois;
        mois =  saisie.lireInteger("Entrez votre mois de naissance");
        
        Integer année;
        année =  saisie.lireInteger("Entrez votre année de naissance");
        
        Date DatedeNaissance = new Date(année , mois , jour);
        String mail = saisie.lireChaine("Entrez votre mail"); 
        
        String inviteMedium = "Choisissez un medium : \r\n";
        for ( int i = 0 ; i < service.ObtenirToutMedium().size() ; i++){
                inviteMedium += service.ObtenirToutMedium().get(i).getNom() + "\r\n" ;
        }
        String medium = saisie.lireChaine(inviteMedium);
        List<Medium> MediumPreferes = new ArrayList<Medium>();
        MediumPreferes.add(service.ChercherMedium(medium));
        Client client = new Client(nom, prenom, civilité, adresse,  numero, mail,  DatedeNaissance,  MediumPreferes);
        service.CreerClient(client);
         
    }
    
       public static void InteractiveHoroscope () {
            Service service = new Service();
            Saisie saisie = new Saisie();
            for ( int i = 0 ; i< service.ObtenirToutPrediction().size() ; i++ )
            {
               // System.out.println ( "identifiant" + service.ObtenirToutPrediction().get(i).getId());
                 //System.out.println ( "niveau  :" + service.ObtenirToutPrediction().get(i).getNiveau());
                 //System.out.println( "texte  : "+ service.ObtenirToutPrediction().get(i).getTexte() + "\r\n" );
            }
            int client = saisie.lireInteger("Choisissez l'identifiant d'un client");
            int travail = saisie.lireInteger("Choisissez l'identifiant d'une prediction Travail");
            int amour = saisie.lireInteger("Choisissez l'identifiant d'une prediction Amoure");
            int sante = saisie.lireInteger("Choisissez l'identifiant d'une prediction sante");
            
            String inviteMedium = "Choisissez le nom d'un medium : \r\n";
            for ( int i = 0 ; i < service.ObtenirToutMedium().size() ; i++){
                inviteMedium += service.ObtenirToutMedium().get(i).getNom() + "\r\n";
            }
            String medium = saisie.lireChaine(inviteMedium);
            
            
            Client cl = null;
            cl = service.ChercherClientParId(client);
            Medium md = service.ChercherMedium(medium) ;
            Prediction PA =  service.ChercherPredictionParId(amour) ;
            Prediction PS =  service.ChercherPredictionParId(sante);
            Prediction PT =  service.ChercherPredictionParId(travail);
            Horoscope hor = new Horoscope ( cl , md , PA , PS , PT);
            service.CreerHoroscope(hor);
            System.out.println ( hor.CorpsHoroscope());
            
        } 
        
    
    public static void main(String[] args) {
      
        Service service = new Service ();
        service.Initialiser();
        //InteractiveClient();
        InteractiveHoroscope();
       
         
        
        
        
        
        
      
        
        
    }

    
}
