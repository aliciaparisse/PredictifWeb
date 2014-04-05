/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.actions;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import predictif.Medium;

/**
 *
 * @author Administrateur
 */
public class ListeMediumAction extends Action {

    @Override
    public void execute(HttpServletRequest requete) {
        List<Medium> listMedium = service.ObtenirToutMedium();
        
        requete.setAttribute("Liste de Mediums", listMedium);
        
    }
    
    
}
