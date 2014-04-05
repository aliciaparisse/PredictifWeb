/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package predictif.DAO;

import java.util.List;
import javax.persistence.Query;
import predictif.Prediction;

/**
 *
 * @author Amine
 */
public class PredictionDaoJpa implements PredictionDao {

    @Override
    public void createPrediction(Prediction prediction) {
         JPAutil.obtenirEntityManager().persist(prediction);
    }

    public PredictionDaoJpa() {
    }

    @Override
    public List<Prediction> findAllPrediction() {
        Query query = JPAutil.obtenirEntityManager().createQuery("select p from"
                + " Prediction p");
        return  (List<Prediction>) query.getResultList();
    }

    @Override
    public List<Prediction> findPredictionByLevel(int level) {
         Query query = JPAutil.obtenirEntityManager().createQuery("select p from"
                + " Prediction p where d.niveau = :niveau");
         query.setParameter("niveau", level  );
        return  (List<Prediction>) query.getResultList();
    }

    @Override
    public Prediction findPredictionById(int id) {
        Query query = JPAutil.obtenirEntityManager().createQuery("select p from"
                + " Prediction p where p.id = :id");
         query.setParameter("id", id  );
        return  (Prediction) query.getSingleResult();
    }

    @Override
    public List<Prediction> findPredictionByType(Class type) {
        Query query = JPAutil.obtenirEntityManager().createQuery("select p from"
                + " Prediction p where TYPE(d) = :type");
         query.setParameter("type", type  );
        return  (List<Prediction>) query.getResultList();
    }
    
    
    
}
