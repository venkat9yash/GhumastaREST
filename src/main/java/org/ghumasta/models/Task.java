package org.ghumasta.models;

import java.sql.Timestamp;
import javax.xml.bind.annotation.*;

/**
 * Created by YashGunapati1 on 2/1/15.
 */
public class Task {
    Timestamp timeOfCreation;
    String taskDescription;

    public Task(String TaskData){
        timeOfCreation = new Timestamp(new java.util.Date().getTime());
        taskDescription = TaskData;
    }
    public Timestamp getTimeOfCreation() {
        return timeOfCreation;
    }
    public String getTaskDescription(){
        return taskDescription;

    }



}
