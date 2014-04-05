/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package predictif;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity 
public class PredictionAmour extends Prediction {
   
    private String partenaire;
    public PredictionAmour() {
    }

    public PredictionAmour(String partenaire, String texte, int niveau) {
        super(texte, niveau);
        this.partenaire = partenaire;
    }

    public String getPartenaire() {
        return partenaire;
    }

    

    
    
    
    
    
}
