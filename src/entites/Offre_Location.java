
package entites;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Omar Amri
 */
public class Offre_Location {
    
    
    private int id_offrelocation;
    Moyen_Transport id_transport ;
    String num_tel, etat;
    double frais;
    
    String date_debut, date_fin;

    public Offre_Location() {
    }

    public Offre_Location(String num_tel, int id_offrelocation, Moyen_Transport id_transport, String etat, double frais, String date_debut, String date_fin) {
        this.num_tel = num_tel;
        this.id_offrelocation = id_offrelocation;
        this.id_transport = id_transport;
        this.etat = etat;
        this.frais = frais;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }
    
    

    public Offre_Location(String date_debut, String date_fin, double frais, String etat, String num_tel) {
        this.num_tel = num_tel;
        this.etat = etat;
        this.frais = frais;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }
    
    public Offre_Location(String num_tel, String date_debut, String date_fin, double frais, String etat) {
        this.num_tel = num_tel;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.frais = frais;
        this.etat = etat;
    }

    public Offre_Location(String num_tel) {
        this.num_tel = num_tel;
    }
    
    

    public String getNum_tel() {
        return num_tel;
    }

    public int getId_offrelocation() {
        return id_offrelocation;
    }

    public Moyen_Transport getId_transport() {
        return id_transport;
    }

    public String getEtat() {
        return etat;
    }

    public double getFrais() {
        return frais;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public void setId_offrelocation(int id_offrelocation) {
        this.id_offrelocation = id_offrelocation;
    }

    public void setId_transport(Moyen_Transport id_transport) {
        this.id_transport = id_transport;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setFrais(double frais) {
        this.frais = frais;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    @Override
    public String toString() {
        return "Offre_Location{" + "num_tel=" + num_tel + ", id_offrelocation=" + id_offrelocation + ", id_transport=" + id_transport + ", etat=" + etat + ", frais=" + frais + ", date_debut=" + date_debut + ", date_fin=" + date_fin + '}';
    }
    
    

    

    
}
