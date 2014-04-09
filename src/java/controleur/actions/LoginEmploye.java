/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.actions;

import javax.servlet.http.HttpServletRequest;
import predictif.Employé;

/**
 *
 * @author alicia
 */
public class LoginEmploye extends Action {
    
    @Override
    public void execute (HttpServletRequest requete)
    {
        String SidEmp = requete.getParameter("login");
        System.out.println(SidEmp);
        
        int idEmp = Integer.parseInt(SidEmp);
        System.out.println(idEmp);
        Employé unEmploye = (Employé) service.ChercherEmployéParId(idEmp);
        requete.setAttribute("EmployeById", unEmploye);
    }
}
