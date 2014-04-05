/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package predictif.DAO;

import java.util.List;
import predictif.Client;
import predictif.Horoscope;

/**
 *
 * @author Amine
 */
public class HoroscopeDaoJpa implements HoroscopeDao {

    @Override
    public void createHoroscope(Horoscope horoscope) {
         JPAutil.obtenirEntityManager().persist(horoscope);
    }
    
    

    
    
    
    
}
