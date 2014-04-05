/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.DAO;

import java.util.List;
import predictif.Medium;

/**
 *
 * @author Administrateur
 */
public interface MediumDao {
    
     public void createMedium ( Medium medium );
     public Medium findMedium ( String medium );
     public List<Medium> findAllMedium ();
    
}
