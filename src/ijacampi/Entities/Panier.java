/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijacampi.Entities;
import ijacampi.Entities.LignePanier;
import java.util.ArrayList;

/**
 *
 * @author brahim
 */
public class Panier {
    ArrayList<LignePanier> elements;
    public Panier(){
       
        this.elements = new ArrayList();
    }

    public Panier(ArrayList<LignePanier> elements) {
        this.elements = elements;
    }

    public ArrayList<LignePanier> getElements() {
        return elements;
    }

    public void setElements(ArrayList<LignePanier> elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return "Panier{" + "elements=" + elements + '}';
    }
    public void ajouterLigne(LignePanier lp)
    {
        
        this.elements.add(lp);
    }
    public void afficherLigne(){
        for(int i=0;i<this.elements.size();i++)
        {
            System.out.println("produit"+i+":");
            System.out.println(this.elements.get(i).id);
           
            System.out.println(this.elements.get(i).produit_id);
            System.out.println(this.elements.get(i).quantite);
            
            
            
            System.out.println("+++++++++++++++++++++++++++++++");
        }
    }
    
    
    
    
    
    
    
    
    
}
