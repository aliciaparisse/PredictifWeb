package Simulation;

import au.com.bytecode.opencsv.CSVReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import predictif.Client;
import predictif.Employé;
import predictif.Medium;
import predictif.PredictionAmour;
import predictif.PredictionSante;
import predictif.PredictionTravail;
import predictif.SigneAstro;
import predictif.service.Service;


/**
 * La classe LectureDonneesCsv permet (comme son nom l'indique) la lecture de données CSV
 * dans des fichiers. Elle doit être complétée et personnalisée pour interagir avec VOTRE couche
 * service pour la création effective des entités. Elle comprend initialement la lecture d'un fichier
 * Clients et d'un fichier Pays. Une méthode {@link main()} permet de tester cette classe avant de
 * l'intégrer dans le reste de votre code.
 * @author Équipe DASI - 2013/2014
 */

public class LectureDonneesCsv {

    /**
     * Format de date pour la lecture des dates dans les fichiers CSV fournis.
     */
    protected static DateFormat CSV_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    
    /**
     * Format de date pour l'affichage à l'écran.
     */
    protected static DateFormat USER_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    
    /**
     * Le lecteur de fichier CSV.
     * Il doit être initialisé avant l'appel aux méthodes de la classe.
     */
    protected CSVReader lecteurFichier;

    /**
     * Unique constructeur de la classe. Le fichier CSV donné en paramètre doit
     * avoir le point-virgule ';' comme séparateur et être encodé en UTF-8. Le fichier est
     * immédiatement ouvert (en lecture) par ce constructeur.
     * @param cheminVersFichier Chemin vers le fichier CSV.
     * @throws FileNotFoundException Si le chemin vers le fichier n'est pas valide ou le fichier non-lisible.
     */
    public LectureDonneesCsv(String cheminVersFichier) throws FileNotFoundException, UnsupportedEncodingException {

        this.lecteurFichier = new CSVReader(new InputStreamReader(new FileInputStream(cheminVersFichier), "UTF-8"), ';');
    }
    
    /**
     * Ferme le fichier CSV. Les autres méthodes ne doivent plus être appelées après cela.
     * @throws IOException 
     */
    public void fermer() throws IOException {

        this.lecteurFichier.close();
    }

    /**
     * Méthode statique pour lire une date à partir d'une chaîne de caractère.
     * Adapté au format de date des fichiers CSV fournis, par exemple: 2014-02-01.
     * @param date Chaîne de caractère représentant la date.
     * @return La date interpétée ou la date actuelle en cas mauvais format en entrée.
     */
    protected static Date parseDate(String date) {
        try {
            return CSV_DATE_FORMAT.parse(date);
        } catch (ParseException ex) {
            return new Date();
        }
    }
    
    /**
     * Méthode statique pour formater une date pour l'affichage.
     * Par exemple: 01/02/2014.
     * @param date Date à formater.
     * @return Chaîne de caractère représentant la date.
     */
    protected static String formatDate(Date date) {
        return USER_DATE_FORMAT.format(date);
    }

    /**
     * Méthode statique pour afficher l'en-tête d'un fichier CSV lu par le lecteur.
     * L'affichage se fait sur la "sortie d'erreur" (en rouge dans la console sous Netbeans).
     * Le nom des colonnes est précédé de leur index dans le tableau (commençant à 0).
     * @param colonnes le tableau des noms de colonnes.
     */
    protected static void afficherEnTeteCsv(String[] colonnes) {
        
        for (int i=0; i<colonnes.length; i++) {
            if (i>0) {
                System.err.print("; " );
            }
            System.err.print("#" + Integer.toString(i) + " => " + colonnes[i] );
        }
        System.err.println();
    }
    
    /**
     * Lit le fichier CSV, affiche son en-tête, puis appelle la création de Client pour chaque ligne.
     * @param limite Nombre maximum de lignes à lire ou -1 pour ne pas limiter
     * @throws IOException 
     */
    public void lireClients(int limite) throws IOException {

        String[] nextLine;

         // En-tete du fichier CSV
        nextLine = this.lecteurFichier.readNext();
        afficherEnTeteCsv(nextLine);
        
        
        // Lecture des lignes
        while ((nextLine = this.lecteurFichier.readNext()) != null) {
        
            creerClient(nextLine);
            
            // Limite (ou -1 si pas de limite)
            if ( !(limite < 0) && (--limite < 1) ) {
                break;
            }
        }

    }
    public void lireSigneAstro(int limite) throws IOException {

        String[] nextLine;

         // En-tete du fichier CSV
        nextLine = this.lecteurFichier.readNext();
        afficherEnTeteCsv(nextLine);
        
        
        // Lecture des lignes
        while ((nextLine = this.lecteurFichier.readNext()) != null) {
        
            creerSigneAstro(nextLine);
            
            // Limite (ou -1 si pas de limite)
            if ( !(limite < 0) && (--limite < 1) ) {
                break;
            }
        }

    }
    public void lireMedium(int limite) throws IOException {

        String[] nextLine;

         // En-tete du fichier CSV
        nextLine = this.lecteurFichier.readNext();
        afficherEnTeteCsv(nextLine);
        
        
        // Lecture des lignes
        while ((nextLine = this.lecteurFichier.readNext()) != null) {
        
            creerMedium(nextLine);
            
            // Limite (ou -1 si pas de limite)
            if ( !(limite < 0) && (--limite < 1) ) {
                break;
            }
        }

    }
    public void lireEmployé(int limite) throws IOException {

        String[] nextLine;

         // En-tete du fichier CSV
        nextLine = this.lecteurFichier.readNext();
        afficherEnTeteCsv(nextLine);
        
        
        // Lecture des lignes
        while ((nextLine = this.lecteurFichier.readNext()) != null) {
        
            creerEmployé(nextLine);
            
            // Limite (ou -1 si pas de limite)
            if ( !(limite < 0) && (--limite < 1) ) {
                break;
            }
        }

    }
    public void lirePredictionTravail(int limite) throws IOException {

        String[] nextLine;

         // En-tete du fichier CSV
        nextLine = this.lecteurFichier.readNext();
        afficherEnTeteCsv(nextLine);
        
        
        // Lecture des lignes
        while ((nextLine = this.lecteurFichier.readNext()) != null) {
        
            creerPredictionTravail(nextLine);
            
            // Limite (ou -1 si pas de limite)
            if ( !(limite < 0) && (--limite < 1) ) {
                break;
            }
        }

    }
    public void lirePredictionAmour(int limite) throws IOException {

        String[] nextLine;

         // En-tete du fichier CSV
        nextLine = this.lecteurFichier.readNext();
        afficherEnTeteCsv(nextLine);
        
        
        // Lecture des lignes
        while ((nextLine = this.lecteurFichier.readNext()) != null) {
        
            creerPredictionAmour(nextLine);
            
            // Limite (ou -1 si pas de limite)
            if ( !(limite < 0) && (--limite < 1) ) {
                break;
            }
        }

    }
    public void lirePredictionSante(int limite) throws IOException {

        String[] nextLine;

         // En-tete du fichier CSV
        nextLine = this.lecteurFichier.readNext();
        afficherEnTeteCsv(nextLine);
        
        
        // Lecture des lignes
        while ((nextLine = this.lecteurFichier.readNext()) != null) {
        
            creerPredictionSante(nextLine);
            
            // Limite (ou -1 si pas de limite)
            if ( !(limite < 0) && (--limite < 1) ) {
                break;
            }
        }

    }
    /**
     * Créée un Client à partir de sa description.
     * La date de naissance est notamment interpétée comme un objet Date.
     * @param descriptionClient Ligne du fichier CSV de Clients.
     */
    public void creerClient(String[] descriptionClient ) {
        
        Service service = new Service ();
        String civilite = descriptionClient[0];
        String nom = descriptionClient[1];
        String prenom = descriptionClient[2];
        Date dateNaissance = parseDate(descriptionClient[3]);
        String adresse = descriptionClient[4];
        String telephone = descriptionClient[5];
        String email = descriptionClient[6];
        
        //System.out.println("Client: "+  civilite + " " + nom + " " + prenom + ", né le " + formatDate(dateNaissance) + ", habitant à " + adresse + ", téléphone: " + telephone + ", e-mail: " + email);
       
        ArrayList<Medium> mediumprefere = new ArrayList<Medium>();
        List<Medium> toutmedium = service.ObtenirToutMedium();
        Random r = new Random();
        int valeurMin = 0;
        int valeurMax = toutmedium.size();
        int p=1;
       
        
       
            int valeur = valeurMin + r.nextInt(valeurMax - valeurMin);
            mediumprefere.add(toutmedium.get(valeur));

        
        
        
        Client client = new Client( nom , prenom , civilite , adresse ,
       telephone , email , dateNaissance ,  mediumprefere );
        service.CreerClient(client);
        System.out.println( client.getDescription());
        
        
        
    }
    public void creerSigneAstro(String[] descriptionSigne ) {
        
        Service service = new Service ();
        String nom = descriptionSigne[0];
        int numeroMois = Integer.parseInt(descriptionSigne[1]);
        String nomMois = descriptionSigne[2];
        String element = descriptionSigne[3];
        SigneAstro signe = new SigneAstro( nom , numeroMois , nomMois , element );
        //System.out.println(client.getDescription());
        service.CreerSigneAstro(signe);
        
    }
    public void creerMedium(String[] descriptionMedium ) {
        
        Service service = new Service ();
        String civilité = descriptionMedium[0];
        String nom = descriptionMedium[1];
        String talent = descriptionMedium[2];
        String bio = descriptionMedium[3];
        Medium med = new Medium(civilité , nom , talent , bio );
        
        service.CreerMedium(med);
        
    }
    public void creerEmployé(String[] descriptionEmployé ) {
        
        Service service = new Service ();
        String civilité = descriptionEmployé[0];
        String nom = descriptionEmployé[1];
        String prenom = descriptionEmployé[2];
        String login = nom + prenom;
        Date dateNaissance = parseDate(descriptionEmployé[3]);
        String adresse = descriptionEmployé[3];
        String telephone = descriptionEmployé[4];
        String mail = descriptionEmployé[5];
        Employé emp = new Employé(civilité , login ,dateNaissance , adresse , telephone, mail  );
        
        service.CreerEmployé(emp);
        
    }
    public void creerPredictionTravail(String[] descriptionPTravail ) {
        
        Service service = new Service ();
        String force = descriptionPTravail[0];
        String texte = descriptionPTravail[1];
        
        PredictionTravail pred = new PredictionTravail( texte , Integer.parseInt(force)   );
        //System.out.println(client.getDescription());
        service.CreerPrediction(pred);
        
    }
    public void creerPredictionAmour(String[] descriptionPA ) {
        
        Service service = new Service ();
        String force = descriptionPA[0];
        String texte = descriptionPA[1];
        String partenaire = descriptionPA[2];
        
         PredictionAmour pred = new PredictionAmour( partenaire , texte , Integer.parseInt(force) );
        //System.out.println(client.getDescription());
        service.CreerPrediction(pred);
        
    }
    public void creerPredictionSante(String[] descriptionPS ) {
        
        Service service = new Service ();
        String force = descriptionPS[0];
        String texte = descriptionPS[1];
        String conseil = descriptionPS[2];
        
        PredictionSante pred = new PredictionSante( conseil , texte , Integer.parseInt(force) );
        service.CreerPrediction(pred);
        
    }
    
    /**
     * Cette méthode main() permet de tester cette classe avant de l'intégrer dans votre code.
     * Elle exploite initialement un fichier de Client et un fichier de Pays, en limitant la lecture aux
     * 10 premiers éléments de chaque fichier.
     * @param args non utilisé ici
     
    public static void main(String[] args) {
        
        try {
            String fichierClients = "C:\\Temp\\PredictIF-Clients.csv";
            String fichierPays = "C:\\Temp\\IFRoutard-Pays.csv";
            
            LectureDonneesCsv lectureDonneesCsv_Clients = new LectureDonneesCsv(fichierClients);
            
            // Pour tester: limite à 10
            lectureDonneesCsv_Clients.lireClients(10);
            // Puis, quand tout est au point!
            //lectureDonneesCsv.lireClients(-1);

            lectureDonneesCsv_Clients.fermer();

            LectureDonneesCsv lectureDonneesCsv_Pays = new LectureDonneesCsv(fichierPays);
            
            lectureDonneesCsv_Pays.lirePays(10);
            
            lectureDonneesCsv_Pays.fermer();
            
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

    }*/
}
