
package pi.ijacampi;

import pi.ijacampi.entites.Moyen_Transport;
import Services.MoyenTransportService;
import pi.ijacampi.entites.Offre_Location;
import Services.Offre_LocationService;
import java.sql.SQLException;

/**
 *
 * @author Omar Amri
 */
public class PIIjacampi {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        
        Moyen_Transport mt1 = new Moyen_Transport(16, 30, 2, "miniBus","0800TUN136","VIVO","img6");
        Moyen_Transport mt2 = new Moyen_Transport(17, 84, 6, "autoBus","3158TUN218","SETRA","img7");
        Moyen_Transport mt3 = new Moyen_Transport(18, 46, 4, "midiBus","1961TUN208","MARCEDES-BENZ","img8");
        Moyen_Transport mt4 = new Moyen_Transport(19, 4, 1, "voiture","8274TUN166","KIA","img4");
        
        
        MoyenTransportService MoyService = new MoyenTransportService();

        
      //  try {
            
            //MoyService.ajouter(mt1);
          //  MoyService.ajouter(mt2);
          //  MoyService.ajouter(mt3);
          //  MoyService.ajouter(mt4);
          
          //MoyService.supprimer(mt1);
          
          
          
            
        //} catch (SQLException ex) {
       //     System.out.println(ex.getMessage());
       // }
        
        //try {
            //System.out.println(MoyService.rechercheParNbrPlaces(mt4));
         //   System.out.println(MoyService.rechercheParMarque(mt1));
            //System.out.println(MoyService.trierNbrPlaces());
            //System.out.println(MoyService.trierMarque());
            //MoyService.trierNbrPlaces().stream().forEach(moyt -> System.out.println(moyt));
       // } catch (SQLException ex) {
      //      System.out.println(ex.getMessage());
      //  }
        
        
        
        //MoyService.supprimer(mt1);
        
        
        //MoyService.modifier(mt1);
               
        
        //MoyService.afficher().stream().forEach(moyt -> System.out.println(moyt));

        
        
        //Offre_Location off1 = new Offre_Location("Disponible",  34.50, "20/02/2022", "20/03/2022");
        //Offre_Location off2 = new Offre_Location(2, 1, "28 fevrier 2022","7 mars 2022","Disponible", 100.00);
        //Offre_Location off3 = new Offre_Location(3, 4, "15 fevrier 2022","20 fevrier 2022","Epuisé", 50.00);
        //Offre_Location off4 = new Offre_Location(4, 3, "02 mars 2022","10 mars 2022", "Disponible", 120.00);
        
        
       // Offre_LocationService offLoc = new Offre_LocationService();
        

        //offLoc.ajouter(off1);
        //offLoc.ajouter(off2);
        //offLoc.ajouter(off3);
        //offLoc.ajouter(off4);
        
        //offLoc.supprimer(off2);
        
        //offLoc.afficher();
        
        // try {
            
         //   offLoc.ajouter(off1);
         //   offLoc.ajouter(off2);
         //   offLoc.ajouter(off3);
         //   offLoc.ajouter(off4);
            
        ///} catch (SQLException ex) {
        //    System.out.println(ex.getMessage());
        //}
        
        //try {
        //    System.out.println(offLoc.afficher());
       // } catch (SQLException ex) {
       //     System.out.println(ex.getMessage());
      //  }
        
        
        //offLoc.afficher().stream().forEach(offres -> System.out.println(offres));
        
    }
    
}
