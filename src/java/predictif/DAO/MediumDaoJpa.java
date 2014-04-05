/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.DAO;

import java.util.List;
import javax.persistence.Query;
import predictif.Medium;

/**
 *
 * @author Administrateur
 */
public class MediumDaoJpa implements MediumDao{

    @Override
    public void createMedium(Medium medium) {
        JPAutil.obtenirEntityManager().persist(medium);
    }

    @Override
    public Medium findMedium(String medium) {
        Query query = JPAutil.obtenirEntityManager().createQuery("select m from Medium m where m.nom =:nom ");
        query.setParameter("nom" , medium);
        return  (Medium) query.getSingleResult();
    }

    @Override
    public List<Medium> findAllMedium() {
       Query query = JPAutil.obtenirEntityManager().createQuery("select m from"
                + " Medium m");
        return  (List<Medium>) query.getResultList();
    }
 
    
}