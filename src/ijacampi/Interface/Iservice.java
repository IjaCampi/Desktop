/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijacampi.Interface;

import java.util.ArrayList;

/**
 *
 * @author brahim
 */
public interface Iservice <T> {
    public ArrayList<T> afficher();
    public void Ajouter(T t);
    public void modifier(T t);
    public void supprimer(T t);
    

}
