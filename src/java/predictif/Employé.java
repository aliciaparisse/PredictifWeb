/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Administrateur
 */
@Entity
public class Employé implements Serializable {
    
    @Id
    @GeneratedValue ( strategy = javax.persistence.GenerationType.AUTO )
    private long id;
    private String Civilite;
    private String login;
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date DatedeNaissance;
    private String adresse;
    private String numero;
    private String mail;
    private int nbClient;
    @OneToMany ( mappedBy = "referent")
    private List<Client> clients;

    public Employé() {
    }

    public Employé(String Civilite, String login, Date DatedeNaissance, String adresse, String numero, String mail) {
        this.Civilite = Civilite;
        this.login = login;
        this.DatedeNaissance = DatedeNaissance;
        this.adresse = adresse;
        this.numero = numero;
        this.mail = mail;
        this.nbClient = 0;
    }

   

    public int getNbClient() {
        return nbClient;
    }
    
    public void IncrementerNbClient (Client client ) 
    {
        clients.add(client);
        nbClient++;
    }
    public void EnleverClient ( Client client)
    {
        clients.remove(client);
    }

    public List<Client> getClients() {
        return clients;
    }

    public String getLogin() {
        return login;
    }
    
}
