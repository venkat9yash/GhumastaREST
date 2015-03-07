package org.ghumasta.models;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by YashGunapati1 on 2/1/15.
 */
public class Task {
    private Date timeOfCreation;
    private String taskDescription;
    private int goalUnitId;
    private float taskHours;
    private float donePercentage;
    private ArrayList<String> keyWords;


    public Task(String TaskData){
        timeOfCreation = new Date(new Timestamp(new java.util.Date().getTime()).getTime());
        taskDescription = TaskData;
    }
    public Task(Date creationDate,String TaskData){
        timeOfCreation = new Timestamp(creationDate.getTime());
        taskDescription = TaskData;
    }
    public Date getTimeOfCreation() {
        return timeOfCreation;
    }
    public String getTaskDescription(){
        return taskDescription;

    }



}
