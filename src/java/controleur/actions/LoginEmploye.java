/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.actions;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import predictif.Client;
import predictif.Employé;

/**
 *
 * @author alicia
 */
public class LoginEmploye extends Action 
{
    
    @Override
    public void execute (HttpServletRequest requete)
    {
        String SidEmp = requete.getParameter("login");
        if (!SidEmp.equals(""))
        {
            int idEmp = Integer.parseInt(SidEmp);
            String empExiste = null; 
            requete.setAttribute("serviceUsed", service);
            try
            {
                service.ChercherEmployéParId(idEmp);
                empExiste = "oui";
                
                HttpSession session = (HttpSession) requete.getAttribute("sessionOuverte");
                Employé sessionEmp = service.ChercherEmployéParId(idEmp);
                session.setAttribute("user", sessionEmp);
                
                List<Client> listClient = service.ChercherEmployéParId(idEmp).getClients();
                requete.setAttribute("listeClient", listClient);
            }
            catch (NullPointerException e1)
            {
                empExiste = "non";
            }
            finally
            {
                System.out.println("java : " + empExiste);
                requete.setAttribute("employeExiste", empExiste);
            }
        }
    }
}
