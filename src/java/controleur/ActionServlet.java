package controleur;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import controleur.actions.Action;
import controleur.actions.ChoixPrediction;
import controleur.actions.ChooseMedium;
import controleur.actions.ClientRegister;
import controleur.actions.CreationHoroscope;
import controleur.actions.DisplayHoroscope;
import controleur.actions.EnvoieMail;
import controleur.actions.ListeMediumAction;
import controleur.actions.LoginEmploye;
import controleur.actions.TraitementClient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import predictif.Employé;
import predictif.service.Service;

/**
 *
 * @author Administrateur
 */
public class ActionServlet extends HttpServlet {

    private Service service;
    private String clientChoisi;
    private String unchecked= "correct";
    
    protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Création de session pour l'employé connecté
        HttpSession session = request.getSession(true);
        request.setAttribute("sessionOuverte", session);
        if (request.getParameter("todo").equals("ConnectionEmploye"))
        {
            String tache = "ConnectionEmploye";
            Action action = this.getAction(tache);
            action.setServiceMetier(this.getServiceMetier());
            action.execute(request);
            String vue = this.setVue(tache);    
            request.getRequestDispatcher(vue).forward(request, response);
        }
        else
        {
            Employé sessionEmp = (Employé) session.getAttribute("user");
            // Vérification si on a bien une session en cours pendant la navigation
            // Sinon, retour à la page de login.
            if (sessionEmp == null)
                request.getRequestDispatcher("VueLogInEmploye").forward(request, response);
            else
            {
                String tache = request.getParameter("todo");
                Action action = null;
                
                // Vérification si on a cliqué sur les boutons suivant ou précédent sur la page de traitement
                // du client afin de récupérer la session de traitement en cours.
                if ("HoroscopeSuivant".equals(tache) || "HoroscopePrecedent".equals(tache) || "AfficherHoroscopeCree".equals(tache))
                    action = (Action) session.getAttribute("instanceTraitementClient");
                else
                    action = this.getAction(tache);
                
                // Vérification si un client a bien été coché dans la liste des clients avant de passer à la suite
                if ("TraiterClient".equals(tache))
                {
                    clientChoisi = request.getParameter("choixClient");
                    unchecked= "correct";
                    if (clientChoisi == null)
                        unchecked = "incorrect";
                    request.setAttribute("clientCoché", unchecked);
                    session.setAttribute("instanceTraitementClient", action);
                }
                
                action.setServiceMetier(this.getServiceMetier());
                
                // Si appui sur bouton suivant ou précédent sur la page de traitement
                // du client : On effectue les méthodes appropriées et pas execute.
                if ("HoroscopeSuivant".equals(tache))
                {
                    ((DisplayHoroscope) action).afficherHoSuivant (request);
                }
                else if ("HoroscopePrecedent".equals(tache))
                {
                    ((DisplayHoroscope) action).afficherHoPrecedent (request);
                }
                else if ("AfficherHoroscopeCree".equals(tache))
                {
                    ((DisplayHoroscope) action).afficherHoroscopeCree (request);
                }
                else
                {
                    action.execute(request);
                }
                
                String vue = this.setVue(tache);
                request.getRequestDispatcher(vue).forward(request, response);
            }
        }
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
        else if ("TraiterClient".equals (todo))
        {
            action = new TraitementClient();
        }
        else if ("DisplayMedium".equals(todo))
        {
            action = new ChooseMedium();
        }
        else if ("AfficherDernierHoroscope".equals(todo))
        {
            action = new DisplayHoroscope();
        }
        else if ("AfficherPredictionAmour".equals(todo))
        {
            action = new CreationHoroscope();
        }
        else if ("ChoixForce".equals(todo))
        {
            action = new ChoixPrediction();
        }
        else if ("EnvoyerMail".equals(todo))
        {
            action = new EnvoieMail();
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
            vue ="VueLogInEmploye.jsp";
        }        
        else if ("InscriptionClient".equals(todo))
        {
            vue ="VueChoixMedium.jsp";
        }
        else if ("TraiterClient".equals (todo))
        {
            // Si l'employé n'a pas choisi de client, on retourne sur la même page
            // Sinon on passe à la suite pour le traitement du client.
            if (clientChoisi != null)
            {
                vue = "VueTraitementClient.jsp";
            }
            else
            {
                vue ="VueLogInEmploye.jsp";
            }
        }
        else if ("DisplayMedium".equals(todo))
        {
            vue = "ConfirmationInscriptionPage.jsp";
        }
        else if ("AfficherDernierHoroscope".equals(todo))
        {
            vue = "VueTraitementClient.jsp";
        }
        else if ("HoroscopeSuivant".equals(todo))
        {
            vue = "VueTraitementClient.jsp";
        }
        else if ("HoroscopePrecedent".equals(todo))
        {
            vue = "VueTraitementClient.jsp";
        }
        else if ("ChoixForce".equals(todo))
        {
            vue = "VueTraitementClient.jsp";
        }
        else if ("AfficherPredictionAmour".equals(todo))
        {
            vue = "VueTraitementClient.jsp";
        }
        else if ("AfficherHoroscopeCree".equals(todo))
        {
            vue = "VueTraitementClient.jsp";
        }
        else if ("EnvoyerMail".equals(todo))
        {
            vue = "VueLogInEmploye.jsp";
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
