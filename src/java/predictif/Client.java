/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import predictif.service.Service;
@Entity
public class Client implements Serializable {
    
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO )
    private long id;
    private String Nom;
    private String Prenom;
    private String Civilite;
    private String AP;
    private String Numeros;
    private String Mail;
    @Temporal (TemporalType.DATE)
    private java.util.Date DatedeNaissance;
    @ManyToOne
    private SigneAstro SigneAstro;
    private boolean Pub;
    @ManyToOne
    private Employé referent;
    @ManyToMany
    private List<Medium> MediumPreferes = new ArrayList<Medium>();
    @OneToMany
    private List<Horoscope> HoroscopePrecedent;

    public Client() {
    }

    public Client(  boolean Pub , String Nom, String Prenom, 
            String Civilite, String AP , String Numeros , String Mail , int AnnéeNaissance , int MoisNaissance 
            , int JourNaissance , List<Medium> MediumPreferes ) {
              
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Civilite = Civilite;
        this.DatedeNaissance = new Date(AnnéeNaissance - 1900 , MoisNaissance , JourNaissance  );
        this.AP=AP;
        this.Numeros=Numeros;
        this.Mail=Mail;
        this.Pub = Pub;
        this.MediumPreferes = MediumPreferes;
    }

    public Client(String Nom, String Prenom, String Civilite, String AP, String Numeros, String Mail, Date DatedeNaissance,  List<Medium> MediumPreferes) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Civilite = Civilite;
        this.AP = AP;
        this.Numeros = Numeros;
        this.Mail = Mail;
        this.DatedeNaissance = DatedeNaissance;
        this.Pub = false;
        this.MediumPreferes = MediumPreferes;
    }

    public Client(List<Horoscope> HoroscopePrecedent) {
        this.HoroscopePrecedent = HoroscopePrecedent;
    }

    public String getNom() {
        return Nom;
    }
    
    public int GetMoisNaissance() {
           return DatedeNaissance.getMonth();
    }   

    public void setSigneAstro(predictif.SigneAstro SigneAstro) {
        this.SigneAstro = SigneAstro;
    }

    public void setReferent(Employé referent) {
        this.referent = referent;
    }

    public List<Medium> getMediumPreferes() {
        return MediumPreferes;
    }
       
     public String getAP() {
        return AP;
    }

    public String getNumeros() {
        return Numeros;
    }

    public String getMail() {
        return Mail;
    }

    public List<Horoscope> getHoroscopePrecedent() {
        return HoroscopePrecedent;
    }

    public String getPrenom() {
        return Prenom;
    }

    public long getId() {
        return id;
    }

    public predictif.SigneAstro getSigneAstro() {
        return SigneAstro;
    }

    public String getCivilite() {
        return Civilite;
    }

    public Date getDatedeNaissance() {
        return DatedeNaissance;
    }

    public Employé getReferent() {
        return referent;
    }
    
    public String getDescription (){
        String result = "Client: "+  this.Civilite + " " + this.Nom + " " + this.Prenom + ", né le " 
                + DatedeNaissance + ", habitant à " + AP 
                + ", téléphone: " + Numeros + ", e-mail: " + Mail + "\n\r" 
                + "Votre Signe Astro: " + SigneAstro.getNom() + "\n\r" + " Vos mediums preferés";
        for ( Medium m : MediumPreferes)
        {
            result += " " + m.getNom();
        }
        result+= "\r\n";
        result+= "\r\n";
        return result;
                
    }

    public void setMediumPreferes(List<Medium> MediumPreferes) {
        this.MediumPreferes = MediumPreferes;
    }
    
}
