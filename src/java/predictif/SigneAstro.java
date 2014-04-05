/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class SigneAstro {
   
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long Id;
   private String Nom;
   private int Mois;
   private String nomMois;
   private String Element;
    @OneToMany(mappedBy = "SigneAstro")
    private List<Client> clients;
    @OneToOne(mappedBy = "SigneAstro")
    private Client client;

    public SigneAstro() {
    }

    public SigneAstro(String Nom, int Mois, String nomMois, String Element) {
        this.Nom = Nom;
        this.Mois = Mois;
        this.nomMois = nomMois;
        this.Element = Element;
    }
   
    

    public String getNom() {
        return Nom;
    }
   
   
   
    
   
}
