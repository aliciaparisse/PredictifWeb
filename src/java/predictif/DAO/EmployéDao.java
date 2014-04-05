/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.DAO;

import java.util.List;
import predictif.Employé;

/**
 *
 * @author Administrateur
 */
public interface EmployéDao {
 
    public void createEmployé ( Employé employé);
    public Employé findEmployéMin();
    public List<Employé> findAllEmploye ();
    public Employé findEmployeById (int id);
    public Employé findEmployeByLogin ( String login );
    public void UpdateEmploye (Employé employé);
}
