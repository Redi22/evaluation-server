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
public class Task implements Serializable{

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public double getPercentile() {
        return percentile;
    }

    public void setPercentile(double percentile) {
        this.percentile = percentile;
    }
    int id;

    public Task(int id, String title, String description, boolean complete, int serviceId, int teacherId, double percentile , String levelName) {
        this.id = id;
        this.name = title;
        this.description = description;
        this.complete = complete;
        this.serviceId = serviceId;
        this.teacherId = teacherId;
        this.percentile = percentile;
        this.levelName = levelName;

    }
    public Task(String title, String description, boolean complete, int serviceId, int teacherId, double percentile , String levelName) {
        this.name = title;
        this.description = description;
        this.complete = complete;
        this.serviceId = serviceId;
        this.teacherId = teacherId;
        this.percentile = percentile;
        this.levelName = levelName;
    }
    private String name;
    private String description;

    public Task(String name, String description, boolean complete, int serviceId, int teacherId, double percentile) {
        this.name = name;
        this.description = description;
        this.complete = complete;
        this.serviceId = serviceId;
        this.teacherId = teacherId;
        this.percentile = percentile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
    private boolean complete;
    private int serviceId;
    private int teacherId;
    private double percentile;
    private String levelName;
}
