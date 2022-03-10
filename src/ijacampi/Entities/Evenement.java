/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijacampi.Entities;

/**
 *
 * @author brahim
 */
public class Evenement {
    private int id;
    private String name;

    public Evenement(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Evenement(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", name=" + name + '}';
    }
    
}
