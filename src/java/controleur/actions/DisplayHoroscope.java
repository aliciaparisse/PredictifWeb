/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controleur.actions;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Jean
 */
public class DisplayHoroscope extends Action
{

    @Override
    public void execute(HttpServletRequest requete) 
    {
        String boutonAppuye = "oui";
        requete.setAttribute("boutonAppuye", boutonAppuye);
        
    }
    
}
