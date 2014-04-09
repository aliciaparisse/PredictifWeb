/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.DAO;

import java.util.List;
import javax.persistence.Query;
import predictif.Employé;

/**
 *
 * @author Administrateur
 */
public class EmployéDaoJpa implements EmployéDao {

    @Override
    public void createEmployé(Employé employé) {
        JPAutil.obtenirEntityManager().persist(employé);
    }

    public EmployéDaoJpa() {
    }

    @Override
    public Employé findEmployéMin() {
      
        return (Employé) JPAutil.obtenirEntityManager().createQuery("select "
                + "e from Employé e order by e.nbClient").setMaxResults(1).getSingleResult();
    }

    @Override
    public List<Employé> findAllEmploye() {
         Query query = JPAutil.obtenirEntityManager().createQuery("select e from"
                + " Employé e");
        return  (List<Employé>) query.getResultList();
    }

    @Override
    public Employé findEmployeById(int id) {
         Query query = JPAutil.obtenirEntityManager().createQuery("select e from"
                + " Employé e where e.id = :id");
         query.setParameter("id", id  );
        return  (Employé) query.getSingleResult();
    }

    @Override
    public void UpdateEmploye(Employé employé) {
        JPAutil.obtenirEntityManager().merge(employé);
    }

    @Override
    public Employé findEmployeByLogin(String login) {
         Query query = JPAutil.obtenirEntityManager().createQuery("select e from"
                + " Employé e where e.Login = :login");
         query.setParameter("login", login  );
        return  (Employé) query.getSingleResult();
    }
    
    
    
}
