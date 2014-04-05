/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Administrateur
 */
@Entity
public class Medium implements Serializable {
    
    @Id
    @GeneratedValue ( strategy = javax.persistence.GenerationType.AUTO )
    int id;
    private String civilite;
    private String nom;
    private String talent;
    private String Biographie;
    
    public Medium() {
    }

    public Medium(String civilite, String nom, String talent, String Biographie) {
        this.civilite = civilite;
        this.nom = nom;
        this.talent = talent;
        this.Biographie = Biographie;
    }

   

    public String getNom() {
        return nom;
    }
    
    
}
