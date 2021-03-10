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
public class User implements Serializable{
    private int id;
    private String fullName;
    private String email;
    private boolean admin;
    private int teacherId;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String fullName, String email, boolean admin, String password , int teacherId) {
        this.fullName = fullName;
        this.email = email;
        this.admin = admin;
        this.password = password;
        this.teacherId = teacherId;
    }

    public User(int id, String fullName, String email, boolean admin, String password , int teacherId) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.admin = admin;
        this.password = password;
        this.teacherId = teacherId;
    }
    private String password;
    
}
