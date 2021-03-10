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
public class Teacher implements Serializable {

    public Teacher(int id, String fullName, String email, String phone, String gender, int levelId) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.levelId = levelId;
    }
    public Teacher(String fullName, String email, String phone, String gender, int levelId) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.levelId = levelId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }
    private int id;
    private String fullName;
    private String email;
    private String phone;

    public Teacher(int id, String fullName, String email, String phone, String gender, int levelId, String levelName) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.levelId = levelId;
        this.levelName = levelName;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
    private String gender;
    private int levelId;
    private String levelName;
    
}
