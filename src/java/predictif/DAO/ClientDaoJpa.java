/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.DAO;


import java.util.List;
import javax.persistence.Query;
import predictif.Client;

/**
 *
 * @author Administrateur
 */
public class ClientDaoJpa implements ClientDao {

    @Override
    public  void createClient(Client client) {
         JPAutil.obtenirEntityManager().persist(client);
    }

    public ClientDaoJpa() {
    }

    @Override
    public List<Client> findClientByName(String nom) {
        Query query = JPAutil.obtenirEntityManager().createQuery("select c from"
                + " Client c where c.Nom = :Nom");
        query.setParameter("Nom", nom  );
        return  (List<Client>) query.getResultList();
    }

    @Override
    public List<Client> findAllClients() {
        Query query = JPAutil.obtenirEntityManager().createQuery("select c from"
                + " Client c");
        return  (List<Client>) query.getResultList();
    }

    @Override
    public List<Client> findClientByFirstName(String prenom) {
         Query query = JPAutil.obtenirEntityManager().createQuery("select c from"
                + " Client c  where c.Prenom = :prenom");
         query.setParameter("prenom", prenom  );
        return  (List<Client>) query.getResultList();
    }

    @Override
    public Client findClientById(int id) {
         Query query = JPAutil.obtenirEntityManager().createQuery("select c from"
                + " Client c where c.id = :id");
         query.setParameter("id", id  );
        return  (Client) query.getSingleResult();
    }

    @Override
    public void updateClient(Client client) {
       JPAutil.obtenirEntityManager().merge(client);
    }

    @Override
    public void removeClient(Client client) {
        JPAutil.obtenirEntityManager().remove(JPAutil.obtenirEntityManager().merge(client));
    }

    
}
