
package pi.ijacampi.entites;

import java.sql.Date;

/**
 *
 * @author Omar Amri
 */
public class Offre_Location {
    
    
    private int id_offrelocation, id_transport ;
    String etat;
    double frais;
    
    Date date_debut, date_fin;

    public Offre_Location() {
    }

    public Offre_Location(int id_offrelocation, int id_transport, String etat, double frais, Date date_debut, Date date_fin) {
        this.id_offrelocation = id_offrelocation;
        this.id_transport = id_transport;
        this.etat = etat;
        this.frais = frais;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public Offre_Location(String etat, double frais, Date date_debut, Date date_fin) {
        this.etat = etat;
        this.frais = frais;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public int getId_offrelocation() {
        return id_offrelocation;
    }

    public int getId_transport() {
        return id_transport;
    }

    public String getEtat() {
        return etat;
    }

    public double getFrais() {
        return frais;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setId_offrelocation(int id_offrelocation) {
        this.id_offrelocation = id_offrelocation;
    }

    public void setId_transport(int id_transport) {
        this.id_transport = id_transport;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setFrais(double frais) {
        this.frais = frais;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    @Override
    public String toString() {
        return "Offre_Location{" + "id_offrelocation=" + id_offrelocation + ", id_transport=" + id_transport + ", etat=" + etat + ", frais=" + frais + ", date_debut=" + date_debut + ", date_fin=" + date_fin + '}';
    }
    
}
