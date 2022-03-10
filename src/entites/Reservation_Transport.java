/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Date;

/**
 *
 * @author Omar Amri
 */
public class Reservation_Transport {
    
    private int id_restranport;
    Date date_reservation;
    Utilisateur user;
    Offre_Location Offre_Location;

    public Reservation_Transport() {
    }
    
    
    

    public Reservation_Transport(int id_restranport, Utilisateur user, Offre_Location Offre_Location, Date date_reservation) {
        this.id_restranport = id_restranport;
        this.date_reservation = date_reservation;
        this.user = user;
        this.Offre_Location = Offre_Location;
    }

    public Reservation_Transport(Date date_reservation, Utilisateur user, Offre_Location Offre_Location) {
        this.date_reservation = date_reservation;
        this.user = user;
        this.Offre_Location = Offre_Location;
    }

    public int getId_restranport() {
        return id_restranport;
    }

    public Date getDate_reservation() {
        return date_reservation;
    }

    public Utilisateur getUser() {
        return user;
    }

    public Offre_Location getOffre_Location() {
        return Offre_Location;
    }

    public void setId_restranport(int id_restranport) {
        this.id_restranport = id_restranport;
    }

    public void setDate_reservation(Date date_reservation) {
        this.date_reservation = date_reservation;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public void setOffre_Location(Offre_Location Offre_Location) {
        this.Offre_Location = Offre_Location;
    }

    @Override
    public String toString() {
        return "Reservation_Transport{" + "id_restranport=" + id_restranport + ", date_reservation=" + date_reservation + ", user=" + user.toString() + ", Offre_Location=" + Offre_Location.toString() + '}';
    }
    
    
    
    
    
}
