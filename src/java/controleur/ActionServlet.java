package controleur;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import controleur.actions.Action;
import controleur.actions.ClientRegister;
import controleur.actions.ListeMediumAction;
import controleur.actions.LoginEmploye;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import predictif.service.Service;

/**
 *
 * @author Administrateur
 */
public class ActionServlet extends HttpServlet {

    private Service service;
    
    
    protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String tache = request.getParameter("todo");
        Action action = this.getAction(tache);
        action.setServiceMetier(this.getServiceMetier());
        action.execute(request);
        String vue = this.setVue(tache);    
        request.getRequestDispatcher(vue).forward(request, response);
        
    }
        
    
    public Service getServiceMetier ()
    {
        if (service == null)
        {
            service = new Service();
        }
        return service;
    }
    
    private Action getAction (String todo)
    {
        Action action = null;
        
        if ("VoirListeMedium".equals (todo))
        {
            action = new ListeMediumAction();
        }
        else if ("ConnectionEmploye".equals (todo))
        {
            action = new LoginEmploye();
        }
        
        else if ("InscriptionClient".equals(todo))
        {
            action = new ClientRegister();
        }
        
        return action;
    }
    
    private String setVue (String todo)
    {
        String vue = null;
        if ("VoirListeMedium".equals (todo))
        {
            vue = "VueListeMedium.jsp";
        }
        else if ("ConnectionEmploye".equals (todo))
        {
            vue = "VueLoggedIn.jsp";
        }
        
        else if ("InscriptionClient".equals(todo))
        {
            vue ="VueChoixMedium.jsp";
        }
        return vue;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
