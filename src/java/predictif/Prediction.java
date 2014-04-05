/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package predictif;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;


@Entity
@Inheritance ( strategy = InheritanceType.JOINED)
public abstract class  Prediction implements Serializable {
    
    @Id
    @GeneratedValue ( strategy = javax.persistence.GenerationType.AUTO )
    private Long id;
    protected String texte;
    protected int niveau;

    public Prediction() {
    }

    public Prediction(String texte , int niveau) {
        this.texte = texte;
        this.niveau = niveau;
    }

    public String getTexte() {
        return texte;
    }

    public int getNiveau() {
        return niveau;
    }

    public Long getId() {
        return id;
    }
    
    
}
