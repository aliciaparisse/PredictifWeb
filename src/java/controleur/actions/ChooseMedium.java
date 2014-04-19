/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.actions;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author alicia
 */
public class ChooseMedium extends Action {
    
    @Override
    public void execute(HttpServletRequest requete) {
        
        requete.setAttribute("serviceUsed", service);
    }
    
}
