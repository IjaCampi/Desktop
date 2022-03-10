
package Test;

import entites.Moyen_Transport;
import Services.MoyenTransportService;
import entites.Offre_Location;
import Services.Offre_LocationService;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Omar Amri
 */
public class TestMain {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        
        Moyen_Transport mt1 = new Moyen_Transport(30, "miniBus","0800TUN136","VIVO");
        Moyen_Transport mt2 = new Moyen_Transport(84, "autoBus","3158TUN218","SETRA");
        Moyen_Transport mt3 = new Moyen_Transport(46, "midiBus","1961TUN208","MARCEDES-BENZ");
        //Moyen_Transport mt4 = new Moyen_Transport(4, "voiture","8274TUN166","KIA");
        
        
        MoyenTransportService MoyService = new MoyenTransportService();

        
      try {
            
            //MoyService.ajouter(mt1);
            //MoyService.ajouter(mt2);
            //MoyService.ajouter(mt3);
            //MoyService.ajouter(mt4);
          
          MoyService.supprimer(mt1);
          
          
          
            
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
        
        try {
            //System.out.println(MoyService.rechercheParNbrPlaces(mt4));
         //   System.out.println(MoyService.rechercheParMarque(mt1));
            //System.out.println(MoyService.trierNbrPlaces());
            //System.out.println(MoyService.trierMarque());
            MoyService.trierNbrPlaces().stream().forEach(moyt -> System.out.println(moyt));
       } catch (SQLException ex) {
        System.out.println(ex.getMessage());
       }
        
        
        
        //MoyService.supprimer(mt1);
        
        
        //MoyService.modifier(mt1);
               
        
        //MoyService.afficher().stream().forEach(moyt -> System.out.println(moyt));

        
        //Date d1 = Date.valueOf(LocalDate.of(2022, Month.FEBRUARY, 20));
        //Date d2 = Date.valueOf(LocalDate.of(2022, Month.MARCH, 20));
        
        //Offre_Location off1 = new Offre_Location(24405246, "Disponible",  34.50, d1, d2);
        //Offre_Location off2 = new Offre_Location(2, 1, "28 fevrier 2022","7 mars 2022","Disponible", 100.00);
        //Offre_Location off3 = new Offre_Location(3, 4, "15 fevrier 2022","20 fevrier 2022","Epuisé", 50.00);
        //Offre_Location off4 = new Offre_Location(4, 3, "02 mars 2022","10 mars 2022", "Disponible", 120.00);
        
        
       //Offre_LocationService offLoc = new Offre_LocationService();
        

        //offLoc.ajouter(off1);
        
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
