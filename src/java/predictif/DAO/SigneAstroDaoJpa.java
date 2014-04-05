/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.DAO;

import javax.persistence.Query;
import predictif.SigneAstro;

/**
 *
 * @author Administrateur
 */
public class SigneAstroDaoJpa implements SigneAstroDao {

    @Override
    public void createSigneAstro(SigneAstro SigneAstro) {
       JPAutil.obtenirEntityManager().persist(SigneAstro);
    }

    public SigneAstroDaoJpa() {
    }

    @Override
    public SigneAstro findSigneAstro(int Mois) {
        Query query = JPAutil.obtenirEntityManager().createQuery("select s from SigneAstro s where s.Mois = :Mois");
        query.setParameter("Mois", Mois );
        return  (SigneAstro) query.getSingleResult();
    }
    
     
    
}
