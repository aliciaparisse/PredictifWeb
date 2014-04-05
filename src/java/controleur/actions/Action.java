/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.actions;

import javax.servlet.http.HttpServletRequest;
import predictif.service.Service;

/**
 *
 * @author Administrateur
 */
public abstract class Action {
    protected Service service;
    public void setServiceMetier (Service unService)
    {
        service = unService;
    }
    
    public abstract void execute (HttpServletRequest requete);
    
}
