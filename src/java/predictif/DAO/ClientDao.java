/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.DAO;
import java.util.List;
import predictif.Client;

/**
 *
 * @author Administrateur
 */
public interface ClientDao {
    
    public void createClient ( Client client);
    public List<Client> findClientByName(String nom);
    public List<Client> findAllClients ();
    public List<Client> findClientByFirstName ( String prenom);
    public Client findClientById (int id);
    public void updateClient ( Client client);
    public void removeClient ( Client client);
    
}
