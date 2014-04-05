/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.service;


import Simulation.LectureDonneesCsv;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import predictif.Client;
import predictif.DAO.ClientDao;
import predictif.DAO.ClientDaoJpa;
import predictif.DAO.EmployéDao;
import predictif.DAO.EmployéDaoJpa;
import predictif.DAO.HoroscopeDao;
import predictif.DAO.HoroscopeDaoJpa;
import predictif.DAO.JPAutil;
import predictif.DAO.MediumDao;
import predictif.DAO.MediumDaoJpa;
import predictif.DAO.PartenaireDao;
import predictif.DAO.PartenaireDaoJpa;
import predictif.DAO.PredictionDao;
import predictif.DAO.PredictionDaoJpa;
import predictif.DAO.SigneAstroDao;
import predictif.DAO.SigneAstroDaoJpa;
import predictif.SigneAstro;
import predictif.Employé;
import predictif.Horoscope;
import predictif.Medium;
import predictif.Partenaire;
import predictif.Prediction;
        

/**
 *
 * @author Administrateur
 */
    public class Service {

        private final ClientDao ClientDao = new ClientDaoJpa();
        private final SigneAstroDao SigneAstroDao = new SigneAstroDaoJpa();
        private final EmployéDao EmployéDao = new EmployéDaoJpa();
        private final MediumDao MediumDao = new MediumDaoJpa();
        private final PartenaireDao PartenaireDao = new PartenaireDaoJpa();
        private final PredictionDao PredictionDao = new PredictionDaoJpa ();
        private final HoroscopeDao HoroscopeDao = new HoroscopeDaoJpa ();

        public Service() {
        }

        public void Initialiser () {
            
             try {
            String fichierMediums = "C:\\Documents and Settings\\Administrateur\\Bureau\\Projets\\data\\PredictIF-Mediums.csv";
            LectureDonneesCsv lectureDonneesCsv_Mediums = new LectureDonneesCsv(fichierMediums);
            // Pour tester: limite à 10
            lectureDonneesCsv_Mediums.lireMedium(-1);
            lectureDonneesCsv_Mediums.fermer();
        
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
             try {
            String fichierEmploye = "C:\\Documents and Settings\\Administrateur\\Bureau\\Projets\\data\\PredictIF-Employes.csv";
            LectureDonneesCsv lectureDonneesCsv_Employe = new LectureDonneesCsv(fichierEmploye);
            // Pour tester: limite à 10
            lectureDonneesCsv_Employe.lireEmployé(-1);
            lectureDonneesCsv_Employe.fermer();
        
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
            
             try {
            String fichierPT = "C:\\Documents and Settings\\Administrateur\\Bureau\\Projets\\data\\PredictIF-Predictions-Travail.csv";
            LectureDonneesCsv lectureDonneesCsv_PT = new LectureDonneesCsv(fichierPT);
            // Pour tester: limite à 10
            lectureDonneesCsv_PT.lirePredictionTravail(-1);
            lectureDonneesCsv_PT.fermer();
        
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
         
              try {
            String fichierPS = "C:\\Documents and Settings\\Administrateur\\Bureau\\Projets\\data\\PredictIF-Predictions-Sante.csv";
            LectureDonneesCsv lectureDonneesCsv_PS = new LectureDonneesCsv(fichierPS);
            // Pour tester: limite à 10
            lectureDonneesCsv_PS.lirePredictionSante(-1);
            lectureDonneesCsv_PS.fermer();
        
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
              try {
            String fichierPA = "C:\\Documents and Settings\\Administrateur\\Bureau\\Projets\\data\\PredictIF-Predictions-Amour.csv";
            LectureDonneesCsv lectureDonneesCsv_PA = new LectureDonneesCsv(fichierPA);
            // Pour tester: limite à 10
            lectureDonneesCsv_PA.lirePredictionAmour(-1);
            lectureDonneesCsv_PA.fermer();
        
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
             
            try {
            String fichierClients = "C:\\Documents and Settings\\Administrateur\\Bureau\\Projets\\data\\PredictIF-SignesAstrologiques.csv";
            LectureDonneesCsv lectureDonneesCsv_Signe = new LectureDonneesCsv(fichierClients);
            // Pour tester: limite à 10
            lectureDonneesCsv_Signe.lireSigneAstro(-1);
            // Puis, quand tout est au point!
            //lectureDonneesCsv.lireClients(-1);

            lectureDonneesCsv_Signe.fermer();
        
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        
        try {
            String fichierClients = "C:\\Documents and Settings\\Administrateur\\Bureau\\Projets\\data\\PredictIF-Clients.csv";
            LectureDonneesCsv lectureDonneesCsv_Clients = new LectureDonneesCsv(fichierClients);
            // Pour tester: limite à 10
            lectureDonneesCsv_Clients.lireClients(50);
            // Puis, quand tout est au point!
            //lectureDonneesCsv.lireClients(-1);

            lectureDonneesCsv_Clients.fermer();
        
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        
            
        }
       
        
        
        
        // Service pour Client
        
        public void CreerClient(Client client) {
            try {
                JPAutil.creerEntityManager();
                try {
                    JPAutil.ouvrirTransaction();
                    int mois = 0; 
                      
                      Calendar cal = Calendar.getInstance();
                      cal.setTime(client.getDatedeNaissance());
                      int month = cal.get(Calendar.MONTH);
                      System.out.println( month +1);
                    client.setSigneAstro( SigneAstroDao.findSigneAstro( month+1));
                    Employé emp = EmployéDao.findEmployéMin();
                    client.setReferent(emp);
                    emp.IncrementerNbClient(client);
                    ClientDao.createClient(client);
                    JPAutil.validerTransaction();
                } catch (Exception e) {
                    e.printStackTrace();
                    JPAutil.annulerTransaction();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public List<Client> ObtenirToutClient ( ) {
            List<Client> result = null;
            try {
                JPAutil.creerEntityManager();
                try {
                    result = ClientDao.findAllClients();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
            
        }
        public List<Client> ChercherClientParNom (String nom){
            List<Client> result = null;
            try {
                JPAutil.creerEntityManager();
                try {
                   
                    result = ClientDao.findClientByName(nom );
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        } 
        public List<Client> ChercherClientParPrenom (String prenom){
             List<Client> result = null;
            try {
                JPAutil.creerEntityManager();
                try {
                    
                    result = ClientDao.findClientByFirstName(prenom );
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
        public List<Medium> ObtenirMediumPrefereParId ( int id ) {
            List<Medium> result = null;
            try {
                JPAutil.creerEntityManager();
                try {
                   
                    result = ClientDao.findClientById(id ).getMediumPreferes();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
        public Client ChercherClientParId ( int id) {
             Client result = null;
            try {
                JPAutil.creerEntityManager();
                try {
                   
                    result = ClientDao.findClientById(id );
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
        public void SupprimerClient ( Client client) {
            try {
                JPAutil.creerEntityManager();
                try {
                    JPAutil.ouvrirTransaction();
                    client.getReferent().EnleverClient(client);
                    EmployéDao.UpdateEmploye(client.getReferent());
                    ClientDao.removeClient (client);
                    JPAutil.validerTransaction();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        public void MettreAjourClient ( Client client) {
              try {
                JPAutil.creerEntityManager();
                try {
                    JPAutil.ouvrirTransaction();
                    ClientDao.updateClient(client);
                    JPAutil.validerTransaction();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        
        // Service pour SigneAstro
        
        public void CreerSigneAstro(SigneAstro SigneAstro) {

            try {
                JPAutil.creerEntityManager();
                try {
                    JPAutil.ouvrirTransaction();
                    SigneAstroDao.createSigneAstro(SigneAstro);
                    JPAutil.validerTransaction();
                } catch (Exception e) {
                    e.printStackTrace();
                    JPAutil.annulerTransaction();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public SigneAstro ChercherSigneAstro(int Mois) {
            SigneAstro result = null;
            try {
                
                JPAutil.creerEntityManager();
                try {
                    
                    result = SigneAstroDao.findSigneAstro(Mois);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return result;
        }
        
        
        // Service pour Employé
        
        public void CreerEmployé(Employé employé) {
            try {
                JPAutil.creerEntityManager();
                try {
                    JPAutil.ouvrirTransaction();
                    EmployéDao.createEmployé(employé);
                    JPAutil.validerTransaction();
                } catch (Exception e) {
                    e.printStackTrace();
                    JPAutil.annulerTransaction();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public Employé ChercherEmployéMin() {
            Employé result = null;
            try {
                JPAutil.creerEntityManager();
                try {
                    
                    result = EmployéDao.findEmployéMin();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return result;
        }
        public Employé ChercherEmployéParId ( int id ) {
            Employé result = null;
            try {
                JPAutil.creerEntityManager();
                try {
                    result = EmployéDao.findEmployeById(id );
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result; 
        }
        public List<Employé> ObtenirToutEmployé () {
            List<Employé> result = null; 
            try {
                JPAutil.creerEntityManager();
                try {
                    result = EmployéDao.findAllEmploye();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
        public List<Client> ChercherClientEmployé ( String login ){
            List<Client> result = null; 
            try {
                JPAutil.creerEntityManager();
                try {
                    result = EmployéDao.findEmployeByLogin(login).getClients();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
        
        // Service pour Medium
        
        public void CreerMedium(Medium medium) {

            try {
                JPAutil.creerEntityManager();
                try {
                    JPAutil.ouvrirTransaction();
                    MediumDao.createMedium(medium);
                    JPAutil.validerTransaction();
                } catch (Exception e) {
                    e.printStackTrace();
                    JPAutil.annulerTransaction();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public Medium ChercherMedium ( String medium){
            Medium result = null;
            try {
                JPAutil.creerEntityManager();
                try {
                   
                    result = MediumDao.findMedium(medium );
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
        public List<Medium> ObtenirToutMedium ( ) {
            List<Medium> result = null; 
            try {
                JPAutil.creerEntityManager();
                try {
                    result = MediumDao.findAllMedium();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
        // Service pour Partenaire
        
        public void CreerPartenaire ( Partenaire partenaire  ){
            try {
                JPAutil.creerEntityManager();
                try {
                    JPAutil.ouvrirTransaction();
                    PartenaireDao.createPartenaire(partenaire);
                    JPAutil.validerTransaction();
                } catch (Exception e) {
                    e.printStackTrace();
                    JPAutil.annulerTransaction();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
        
        // Service pour Prediction
        
        public void CreerPrediction ( Prediction prediction){
            try {
                JPAutil.creerEntityManager();
                try {
                    JPAutil.ouvrirTransaction();
                    PredictionDao.createPrediction(prediction);
                    JPAutil.validerTransaction();
                } catch (Exception e) {
                    e.printStackTrace();
                    JPAutil.annulerTransaction();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public List<Prediction> ObtenirToutPrediction (){
             List<Prediction> result = null; 
            try {
                JPAutil.creerEntityManager();
                try {
                    result = PredictionDao.findAllPrediction();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
        public List<Prediction> ChercherPredictionParType ( Class type){
             List<Prediction> result = null; 
            try {
                JPAutil.creerEntityManager();
                try {
                    result = PredictionDao.findPredictionByType(type);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
        public List<Prediction> ChercherPredictionParNiveau ( int niveau){
             List<Prediction> result = null; 
            try {
                JPAutil.creerEntityManager();
                try {
                    result = PredictionDao.findPredictionByLevel(niveau);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
        public Prediction ChercherPredictionParId ( int id){
             Prediction result = null; 
            try {
                JPAutil.creerEntityManager();
                try {
                    result = PredictionDao.findPredictionById(id);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
        // Service pour Horoscope
        
        public void CreerHoroscope ( Horoscope horoscope) {
            try {
                JPAutil.creerEntityManager();
                try {
                    JPAutil.ouvrirTransaction();
                    HoroscopeDao.createHoroscope(horoscope);
                    horoscope.getClient().getHoroscopePrecedent().add(horoscope);
                    ClientDao.updateClient(horoscope.getClient());
                    JPAutil.validerTransaction();
                    System.out.println(horoscope.CorpsHoroscope());
                } catch (Exception e) {
                    e.printStackTrace();
                    JPAutil.annulerTransaction();
                } finally {
                    JPAutil.fermerEntityManager();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        
        
    }