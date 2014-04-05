package predictif;


import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrateur
 */
@Entity
public class Coordonnees implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String AP;
    private String Numeros;
    private String Mail;

    public Coordonnees() {
    }

    public Coordonnees(String AP, String Numeros, String Mail) {
        this.AP = AP;
        this.Numeros = Numeros;
        this.Mail = Mail;
    }

    public String getAP() {
        return AP;
    }

    public String getNumeros() {
        return Numeros;
    }

    public String getMail() {
        return Mail;
    }
    
    
    
}
