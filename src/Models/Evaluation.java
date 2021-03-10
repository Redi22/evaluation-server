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
public class Evaluation implements Serializable{
    private int id;
    private int taskId;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public Evaluation(String comment, double value , int taskId) {
        this.comment = comment;
        this.value = value;
        this.taskId = taskId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Evaluation(int id, String comment, double value , int taskId) {
        this.id = id;
        this.comment = comment;
        this.value = value;
        this.taskId = taskId;
    }
    private String comment;
    private double value;
}
