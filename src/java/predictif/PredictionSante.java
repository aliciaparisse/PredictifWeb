/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package predictif;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Amine
 */
@Entity
public class PredictionSante extends Prediction  {
    
    protected String conseil;

    public PredictionSante() {
    }

    public PredictionSante(String conseil, String texte, int niveau) {
        super(texte, niveau);
        this.conseil = conseil;
    }

    public String getConseil() {
        return conseil;
    }

    public void setConseil(String conseil) {
        this.conseil = conseil;
    }
    
    
}
