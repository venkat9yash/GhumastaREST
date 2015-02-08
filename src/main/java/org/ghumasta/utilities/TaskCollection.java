package org.ghumasta.utilities;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.google.common.collect.Multiset;
import com.google.common.collect.HashMultiset;
import com.sun.org.apache.xpath.internal.operations.Mult;
import org.ghumasta.models.Task;
import org.ghumasta.mongo.Mongo;


import java.util.ArrayList;
import java.util.Date;
/**
 * Created by YashGunapati1 on 2/7/15.
 */


public class TaskCollection extends Mongo{

    private BasicDBObject tempObject;
    public ArrayList<BasicDBObject> objectArrayList = new ArrayList<BasicDBObject>();

    public TaskCollection()
    {
        super();
        connectToDatabase("test");
        loadCollection("test");
    }

    public Multiset<Task> searchByDateRange(Date startDate, Date endDate){
        tempObject = new BasicDBObject();
        tempObject.put(properties.getProperty("mongo_task_attr1"),new BasicDBObject("$gt", startDate).append("$lt", endDate));
        //tempObject.put(properties.getProperty("mongo_task_attr1"), BasicDBObjectBuilder.start("$gte", new Date("2015-02-01T00:00:00.000Z")).add("$lte", new Date("2015-02-09T00:00:00.000Z")).get());
        //tempObject = new BasicDBObject(properties.getProperty("mongo_task_attr2"),"Test");
        DBCursor dbCursor = searchDocument(tempObject);
        return convertIntoTaskList(dbCursor);

    }
    protected Multiset<Task> convertIntoTaskList(DBCursor dbCursor){
        Multiset<Task> taskList = HashMultiset.create();
        while (dbCursor.hasNext()){
            DBObject returnObject = dbCursor.next();
            Task returnTask = new Task((Date)returnObject.get(properties.getProperty("mongo_task_attr1")),returnObject.get(properties.getProperty("mongo_task_attr2")).toString());
            taskList.add(returnTask);

        }
        return taskList;


    }

    public void createMongoObjectToList(Task task){
        tempObject = new BasicDBObject();
        //need to take attributes from log file
        tempObject.put(properties.getProperty("mongo_task_attr1"),task.getTimeOfCreation());
        tempObject.put(properties.getProperty("mongo_task_attr2"),task.getTaskDescription());
        objectArrayList.add(tempObject);
    }
    public boolean insertList(){

        if(objectArrayList != null) {
            insertDocuments(objectArrayList);
            return true;
        }
        else{
            return false;
        }

    }




}
