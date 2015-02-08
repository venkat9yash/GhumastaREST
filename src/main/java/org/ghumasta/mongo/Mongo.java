package org.ghumasta.mongo;

import com.mongodb.*;

import java.io.FileInputStream;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Properties;

public abstract  class Mongo {
    private String host_name;
    private int port_number;
    protected Properties properties;
    private InputStream properties_stream;
    private MongoClient mongo_connection;
    private DB mongo_db;
    private DBCollection mongo_table;

    public Mongo(){

        try{
            properties_stream = new FileInputStream("/Users/YashGunapati1/IdeaProjects/GhumastaREST/src/main/java/org/ghumasta/mongo/mongo.properties");
            properties = new Properties();
            properties.load(properties_stream);
            mongo_connection = new MongoClient(properties.getProperty("mongo_host"),Integer.valueOf(properties.getProperty("mongo_port")));
            System.out.println("Connection Established " + mongo_connection.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean connectToDatabase(String databaseName){
        mongo_db = mongo_connection.getDB(databaseName);
        return (mongo_db !=null) ? true : false ;
    }
    public boolean loadCollection(String collectionName){
        mongo_table = mongo_db.getCollection(collectionName);
        return (mongo_table != null) ? true : false;
    }
    public void insertDocuments(ArrayList<BasicDBObject> dbObjects)
    {
        for (BasicDBObject dbObject : dbObjects){
            mongo_table.insert(dbObject);
        }
    }
    public DBObject getFirstRecord(){
        return mongo_table.findOne();
    }
    public DBCursor searchDocument(BasicDBObject searchObject){
        return mongo_table.find(searchObject);
    }


}
