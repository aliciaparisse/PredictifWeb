/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package predictif.DAO;

import java.util.List;
import predictif.Prediction;

/**
 *
 * @author Amine
 */
public interface PredictionDao {
    
    public void createPrediction ( Prediction prediction);
    public List<Prediction> findAllPrediction ( );
    public List<Prediction> findPredictionByLevel ( int level);
    public Prediction findPredictionById ( int id);
    public List<Prediction> findPredictionByType ( Class type);
    
    
}
