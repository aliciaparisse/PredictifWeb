package predictif;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityManagerFactory;
/**
 *
 * @author Administrateur
 */
//@Embeddable
@Entity
public class Identite {
    
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO )
    private long Id;
    private String Nom;
    private String Prenom;
    private String Civilite;
    // @Temporal (TemporalType.DATE)
    private String DatedeNaissance;

    public Identite() {
    }

    public Identite(String Nom, String Prenom, String Civilite, String DatedeNaissance) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Civilite = Civilite;
        this.DatedeNaissance = DatedeNaissance;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getCivilite() {
        return Civilite;
    }

    public String getDatedeNaissance() {
        return DatedeNaissance;
    }
    
    
    
}
