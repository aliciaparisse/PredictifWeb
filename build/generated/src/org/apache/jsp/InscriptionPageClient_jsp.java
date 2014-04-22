package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class InscriptionPageClient_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("         <link rel=\"stylesheet\" href=\"style.css\" />\n");
      out.write("        <title>Inscription Page Client</title>\n");
      out.write("    </head>\n");
      out.write("    <body>..\n");
      out.write("        <header>\n");
      out.write("            <span class=\"bannertext\"> Prédict'IF...</span>\n");
      out.write("        </header>\n");
      out.write("        <h1>Inscription</h1> \n");
      out.write("        <br>\n");
      out.write("        <form action=\"http://localhost:8080/PredictifWeb/ActionServlet?todo=InscriptionClient\" method=\"POST\">\n");
      out.write("        <section>\n");
      out.write("        \n");
      out.write("            <select name=\"civility\">\n");
      out.write("                <option>Mme </option>\n");
      out.write("                <option>Melle</option>\n");
      out.write("                <option>Mr</option>\n");
      out.write("            </select>\n");
      out.write("            \n");
      out.write("            <span class=\"formulaire\">Nom :<input type=\"text\" name=\"name\" value=\"\" size=\"30\" /><br> </span>\n");
      out.write("            <span class=\"formulaire\">Prénom :<input type=\"text\" name =\"firstName\"  value=\"\" size=\"30\" /><br></span>\n");
      out.write("            <span class=\"formulaire\">Adresse mail :<input type=\"text\" name=\"mailAdress\"  value=\"\" size=\"50\" /><br></span>\n");
      out.write("            <span class=\"formulaire\">Adresse Postale<textarea name =\"postAdress\"  rows=\"4\" cols=\"30\">\n");
      out.write("                </textarea><br></span>\n");
      out.write("            Date de Naissance(Format aaaammjj) : <input type=\"text\" name =\"birthDate\"  value=\"\" size=\"30\" /><br>\n");
      out.write("            Téléphone :<input type=\"text\" name =\"phone\"  value=\"\" size=\"30\" /><br>\n");
      out.write("            <input type=\"checkbox\" name =\"commercial\" value=\"ON\" checked=\"checked\"/> J'accepte de recevoir des offres de nos partenaires commerciaux<br>\n");
      out.write("            <input type=\"checkbox\" name =\"utilisation\"  value=\"ON\" checked=\"checked\" /> J'accepte les conditions d'utilisations de ce service\n");
      out.write("            <input type=\"submit\" value=\"Etape suivante\" name=\"registerInBdd\" />\n");
      out.write("        \n");
      out.write("        </section>\n");
      out.write("        \n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
