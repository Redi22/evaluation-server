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
public class Service implements Serializable{
    
    private int id;
    private String name;
    private int serviceCategoryId;
    private double percentile;
    private String serviceName;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getServiceCategoryId() {
        return serviceCategoryId;
    }

    public void setServiceCategoryId(int serviceCategoryId) {
        this.serviceCategoryId = serviceCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercentile() {
        return percentile;
    }

    public void setPercentile(double percentile) {
        this.percentile = percentile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }
    private String description;

    public Service(String name,  double percentile ,  String description, int levelId , int serviceCategoryId) {
        this.name = name;
        this.serviceCategoryId = serviceCategoryId;
        this.percentile = percentile;
        this.description = description;
        this.levelId = levelId;
    }
    private int levelId;
    
    public Service(int id, String name ,  String description ,double percentile , int levelId , int serviceCategoryId ,String serviceName){
        this.id = id;
        this.description = description;
        this.name =  name;
        this.levelId = levelId;
        this.serviceCategoryId = serviceCategoryId;
        this.percentile = percentile;
        this.serviceName = serviceName;
    }
    public Service( String name , double percentile , String description , int levelId , int serviceCategoryId , String serviceName){
        this.description = description;
        this.name =  name;
        this.levelId = levelId;
        this.serviceCategoryId = serviceCategoryId;
        this.percentile = percentile;
        this.serviceName = serviceName;
    }

    

    
}
