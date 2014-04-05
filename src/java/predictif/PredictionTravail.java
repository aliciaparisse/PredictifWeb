/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package predictif;

import javax.persistence.Entity;

/**
 *
 * @author Amine
 */
@Entity
public class PredictionTravail extends Prediction {

    public PredictionTravail() {
    }

    public PredictionTravail(String texte, int niveau) {
        super(texte, niveau);
    }
    
    
    
}
