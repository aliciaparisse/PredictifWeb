/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package predictif.DAO;
import predictif.Partenaire;

/**
 *
 * @author Amine
 */
public class PartenaireDaoJpa implements PartenaireDao {

    @Override
    public void createPartenaire(Partenaire partenaire) {
       JPAutil.obtenirEntityManager().persist(partenaire);
    }

    public PartenaireDaoJpa() {
    }
    
    
    
    
}
