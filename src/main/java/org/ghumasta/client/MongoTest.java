package org.ghumasta.client;

import org.ghumasta.utilities.TaskCollection;
import org.ghumasta.models.Task;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by YashGunapati1 on 2/7/15.
 */
public class MongoTest {
    public static void main(String [] args)
    {
        try {
            TaskCollection TaskDB = new TaskCollection();
            Task sampleTask = new Task("Final Test");
            TaskDB.createMongoObjectToList(sampleTask);
            TaskDB.insertList();
            Date firstDate = new SimpleDateFormat("yyyy-MM-dd").parse("2015-02-01");
            Date endDate =  new SimpleDateFormat("yyyy-MM-dd").parse("2015-02-09");
            for (Task returnTask : TaskDB.searchByDateRange(firstDate, endDate).elementSet()){
               System.out.println(returnTask.getTimeOfCreation()+":"+returnTask.getTaskDescription());

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
