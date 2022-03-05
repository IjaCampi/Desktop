
package entites;

/**
 *
 * @author Omar Amri
 */
public class Moyen_Transport {
    
    private int id_transport;
    int nbr_place ;
    Agent_transport id_user;
    String type, matricule, marque;

    public Moyen_Transport() {
    }

    public Moyen_Transport(int id_transport, int nbr_place, Agent_transport id_user, String type, String matricule, String marque) {
        this.id_transport = id_transport;
        this.nbr_place = nbr_place;
        this.id_user = id_user;
        this.type = type;
        this.matricule = matricule;
        this.marque = marque;
    }
    
    public Moyen_Transport(String type, String matricule, String marque, int nbr_place) {
        this.type = type;
        this.matricule = matricule;
        this.marque = marque;
        this.nbr_place = nbr_place;
        
    }

    public Moyen_Transport(int nbr_place, String type, String matricule, String marque) {
        this.nbr_place = nbr_place;
        this.type = type;
        this.matricule = matricule;
        this.marque = marque;
    }

    public Moyen_Transport(String matricule) {
        this.matricule = matricule;
    }

    public Moyen_Transport(int id, String type, String matricule, String marque, int nbr_place) {
        this.id_transport=id;
        this.nbr_place = nbr_place;
        this.type = type;
        this.matricule = matricule;
        this.marque = marque;
    }
    
    
    

    public int getId_transport() {
        return id_transport;
    }

    public int getNbr_place() {
        return nbr_place;
    }

    public Agent_transport getId_user() {
        return id_user;
    }

    public String getType() {
        return type;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setId_transport(int id_transport) {
        this.id_transport = id_transport;
    }

    public void setNbr_place(int nbr_place) {
        this.nbr_place = nbr_place;
    }

    public void setId_user(Agent_transport id_user) {
        this.id_user = id_user;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
    
    @Override
    public String toString() {
        return "Moyen_Transport{" + "id_transport=" + id_transport + ", nbr_place=" + nbr_place + ", id_user=" + id_user + ", type=" + type + ", matricule=" + matricule + ", marque=" + marque + '}';
    }
    
    
    
    
}
