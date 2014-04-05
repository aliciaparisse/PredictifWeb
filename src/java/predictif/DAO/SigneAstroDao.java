/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.DAO;

import predictif.SigneAstro;

/**
 *
 * @author Administrateur
 */
public interface SigneAstroDao {
    
    public void createSigneAstro ( SigneAstro SigneAstro);
    public SigneAstro findSigneAstro ( int Mois );
    
}
