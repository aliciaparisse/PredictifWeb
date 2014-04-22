package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import predictif.Employé;
import predictif.Client;
import predictif.service.Service;
import predictif.Medium;
import java.util.List;

public final class VueLogInEmploye_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\" />\r\n");
      out.write("        <title>Bienvenue sur Predict'IF</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <header>\r\n");
      out.write("        </header>\r\n");
      out.write("        <h1>Bonjour ! <br> Veuillez vous connecter !</h1>\r\n");
      out.write("        \r\n");
      out.write("        <form action=\"ActionServlet?todo=ConnectionEmploye\" method=\"POST\"/>    \r\n");
      out.write("            <input type=\"text\" name=\"login\"/>\r\n");
      out.write("            <input type=\"submit\" name=\"Validation\" value=\"Ok\"/>\r\n");
      out.write("        </form>\r\n");
      out.write("        \r\n");
      out.write("        <form action=\"ActionServlet?todo=TraiterClient\" method=\"POST\">\r\n");
      out.write("            <table>\r\n");
      out.write("                <caption>Liste des clients</caption>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th>Nom</th>\r\n");
      out.write("                    <th>Prénom</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("        ");

            if (session.getAttribute("user") != null)
            {
                if(session.getAttribute("listeClient") != null) 
                {
                    List<Client> listClient = (List<Client>) session.getAttribute("listeClient");
                    for (int i=0; i < listClient.size(); i++)
                    {
                        out.print("<tr>");
                        out.print("<th>" + "<input type=\"radio\" name=\"choixClient\" value=\"" + listClient.get(i).getId() + "\"/> " + listClient.get(i).getNom() + "</th>");
                        out.print("<th>" + listClient.get(i).getPrenom() + "</th>");                    
                        out.print("</tr>");
                    }
                }
            }
            else
            {
                if (request.getAttribute("employeExiste") == "oui")
                {
                    if(session.getAttribute("listeClient") != null) 
                    {
                        List<Client> listClient = (List<Client>) session.getAttribute("listeClient");
                        for (int i=0; i < listClient.size(); i++)
                        {
                            out.print("<tr>");
                            out.print("<th>" + "<input type=\"radio\" name=\"choixClient\" value=\"" + listClient.get(i).getId() + "\"/> " + listClient.get(i).getNom() + "</th>");
                            out.print("<th>" + listClient.get(i).getPrenom() + "</th>");                    
                            out.print("</tr>");
                        }
                    }
                }
                else if (request.getAttribute("employeExiste") == "non")
                    out.print("Veuillez rentrer un identifiant correct");
            }
        
      out.write("            \r\n");
      out.write("            </table>\r\n");
      out.write("        ");

            if (request.getAttribute("clientCoché") != null)
            {
                String unchecked = (String) request.getAttribute("clientCoché");
                if (unchecked.equals("incorrect"))
                    out.print("Veuillez sélectionner un client.<br>");
            }
        
      out.write("\r\n");
      out.write("            <input type=\"submit\"  name=\"traitement\" value=\"Traiter\"/>\r\n");
      out.write("        </form>\r\n");
      out.write("         \r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
