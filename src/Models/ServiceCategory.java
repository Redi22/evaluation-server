/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author kk
 */
public class ServiceCategory implements Serializable {

    public ServiceCategory( int id,String name, String description) {
        this.name = name;
        this.id = id;
        this.description = description;
    }
     public ServiceCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }
    private String name;
    private int id;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
