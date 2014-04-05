/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 *
 * @author Administrateur
 */
@Entity
public class Horoscope {
    @Id
    @GeneratedValue ( strategy = javax.persistence.GenerationType.AUTO )
    private long id;
    Client client;
    @ManyToOne
    Medium medium;
    @ManyToOne
    PredictionAmour predictionAmour;
    @ManyToOne
    PredictionSante predictionSante;
    @ManyToOne
    PredictionTravail predictionTravail;

    public Horoscope() {
    }

    public Horoscope(Client client, Medium medium, Prediction predictionAmour, Prediction predictionSante, Prediction predictionTravail) {
        this.client = client;
        this.medium = medium;
        this.predictionAmour = ( PredictionAmour )predictionAmour;
        this.predictionSante = (PredictionSante) predictionSante;
        this.predictionTravail = (PredictionTravail) predictionTravail;
    }
    
    

    public Client getClient() {
        return client;
    }
    
    public String CorpsHoroscope (){
        String corps;
        corps = client.getNom() + "  " + client.getPrenom() + "\r\n";
        corps += client.getAP() +  "\r\n";
        corps += client.getNumeros() + "\r\n";
        corps += " Votre numeros client :" + client.getId() + "\r\n";
        corps += "Votre signe Astro" + client.getSigneAstro().getNom()+ "\r\n" ;
        corps += "Vos mediums preferes :";
        for ( Medium m : client.getMediumPreferes())
        {
            corps += " " + m.getNom();
        }
        corps += "\r\n";
        
        corps += "Cher "+ client.getNom() + " aujourd'hui votre voyance est offerte par"+ medium.getNom();
        corps+="\n\r" + "\n\r" + "\n\r" ;
        corps+= "Travail" + "(" + predictionTravail.getNiveau() + ")"+ predictionTravail.getTexte();
        corps+= "\n\r" +  "Sante" + "(" + predictionSante.getNiveau() + ")" +   predictionSante.getTexte() + "\n\r" + "Conseil : " +  predictionSante.getConseil();
        corps+= "\n\r" + "Amour " + "(" + predictionAmour.getNiveau() + ")"+ " " + predictionAmour.getTexte()+ "\n\r" + "Votre Partenaire : " + predictionAmour.getPartenaire();
                
        return corps;
    }
    
    
    
}
