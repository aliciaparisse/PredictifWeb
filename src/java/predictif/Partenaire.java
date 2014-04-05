package predictif;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amine
 */
@Entity
public class Partenaire {
    
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO )
    private long id;
    String nom;
    String mail;

    public Partenaire() {
    }

    public Partenaire(String nom, String mail) {
        this.nom = nom;
        this.mail = mail;
    }

    public String getNom() {
        return nom;
    }

    public String getMail() {
        return mail;
    }
    
    
    
    
    
}
