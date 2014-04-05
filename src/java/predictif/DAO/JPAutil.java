package predictif.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

/**
 * Cette classe fournit des mÃ©thodes statiques utiles pour accÃ©der aux
 * fonctionnalitÃ©s de JPA (Entity Manager, Entity Transaction). Le nom de
 * l'unitÃ© de persistance (PERSISTENCE_UNIT_NAME) doit Ãªtre conforme Ã  la
 * configuration indiquÃ©e dans le fichier persistence.xml du projet.
 * @author DASI Team
 */
public class JPAutil {

    // *************************************************************************************
    // * TODO: IMPORTANT -- Adapter le nom de l'UnitÃ© de Persistance (cf. persistence.xml) *
    // *************************************************************************************
    /**
     * Nom de l'unitÃ© de persistance utilisÃ©e par la Factory de Entity Manager.
     * <br/><strong>VÃ©rifier le nom de l'unitÃ© de persistance (cf.&nbsp;persistence.xml)</strong>
     */
    public static final String PERSISTENCE_UNIT_NAME = "PredictIFPU";
    /**
     * Factory de Entity Manager liÃ©e Ã  l'unitÃ© de persistance.
     * <br/><strong>VÃ©rifier le nom de l'unitÃ© de persistance indiquÃ©e dans l'attribut statique PERSISTENCE_UNIT_NAME (cf.&nbsp;persistence.xml)</strong>
     */
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    /**
     * GÃ¨re les instances courantes de Entity Manager liÃ©es aux Threads.
     * L'utilisation de ThreadLocal garantie une unique instance courante par Thread.
     */
    private static final ThreadLocal<EntityManager> threadLocalEntityManager = new ThreadLocal<EntityManager>() {

        @Override
        protected EntityManager initialValue() {
            return null;
        }
    };

    // Essai pour avoir des messages de Log dans le bon ordre
    private static void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ex) {
        }
    }

    private static void log(String message) {
    /*    System.out.flush();
        pause(5);
        System.err.println(message);
        System.err.flush();
        pause(5);*/
    }

    ;

    /**
     * CrÃ©Ã©e l'instance courante de Entity Manager (liÃ©e Ã  ce Thread).
     * <br/><strong>Ã€ utiliser uniquement au niveau Service.</strong>
     */
    public static void creerEntityManager() {
        //log("crÃ©ation du contexte de persistance");
        threadLocalEntityManager.set(entityManagerFactory.createEntityManager());
    }

    /**
     * Ferme l'instance courante de Entity Manager (liÃ©e Ã  ce Thread).
     * <br/><strong>Ã€ utiliser uniquement au niveau Service.</strong>
     */
    public static void fermerEntityManager() {
        //log("fermeture du contexte de persistance");
        EntityManager em = threadLocalEntityManager.get();
        em.close();
        threadLocalEntityManager.set(null);
    }

    /**
     * DÃ©marre une transaction sur l'instance courante de Entity Manager.
     * <br/><strong>Ã€ utiliser uniquement au niveau Service.</strong>
     */
    public static void ouvrirTransaction() {
        //log("debut transaction");
        EntityManager em = threadLocalEntityManager.get();
        em.getTransaction().begin();
    }

    /**
     * Valide la transaction courante sur l'instance courante de Entity Manager.
     * <br/><strong>Ã€ utiliser uniquement au niveau Service.</strong>
     * @exception RollbackException lorsque le <em>commit</em> n'a pas rÃ©ussi.
     */
    public static void validerTransaction() throws RollbackException {
        //log("commit transaction");
        EntityManager em = threadLocalEntityManager.get();
        em.getTransaction().commit();
    }

    /**
     * Annule la transaction courante sur l'instance courante de Entity Manager.
     * Si la transaction courante n'est pas dÃ©marrÃ©e, cette mÃ©thode n'effectue aucune opÃ©ration.
     * <br/><strong>Ã€ utiliser uniquement au niveau Service.</strong>
     */
    public static void annulerTransaction() {
        log("rollback transaction");
        EntityManager em = threadLocalEntityManager.get();
        if (em.getTransaction().isActive()) {
            log("rollback transaction effectue");
            em.getTransaction().rollback();
        }
    }

    /**
     * Retourne l'instance courante de Entity Manager.
     * <br/><strong>Ã€ utiliser uniquement au niveau DAO.</strong>
     * @return instance de Entity Manager
     */
    protected static EntityManager obtenirEntityManager() {
        //log("obtention du contexte de persistance");
        return threadLocalEntityManager.get();
    }
}