/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Seif Labidi
 */
public class ReservationSimple {
     private int id_rs;
    public int duree;
    public Date dateDebut;
    public Date dateFin;
    // private User user
    
    public ReservationSimple(int duree, Date dateDebut, Date dateFin) {
        this.duree = duree;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public int getId_rs() {
        return id_rs;
    }

    public void setId_rs(int id_rs) {
        this.id_rs = id_rs;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public ReservationSimple() {
    }

    @Override
    public String toString() {
        return "ReservationSimple{" + "id_rs=" + id_rs + ", duree=" + duree + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id_rs;
        hash = 89 * hash + this.duree;
        hash = 89 * hash + Objects.hashCode(this.dateDebut);
        hash = 89 * hash + Objects.hashCode(this.dateFin);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReservationSimple other = (ReservationSimple) obj;
        if (this.id_rs != other.id_rs) {
            return false;
        }
        if (this.duree != other.duree) {
            return false;
        }
        if (!Objects.equals(this.dateDebut, other.dateDebut)) {
            return false;
        }
        if (!Objects.equals(this.dateFin, other.dateFin)) {
            return false;
        }
        return true;
    }
    
}
