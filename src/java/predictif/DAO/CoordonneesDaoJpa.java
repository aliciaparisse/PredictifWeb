/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.DAO;

import predictif.Coordonnees;

/**
 *
 * @author Administrateur
 */
public class CoordonneesDaoJpa implements CoordonneesDao {

    @Override
    public void createCoordonnes(Coordonnees Coordonnees) {
        JPAutil.obtenirEntityManager().persist(Coordonnees);
    }

    public CoordonneesDaoJpa() {
    }
  
    
}
