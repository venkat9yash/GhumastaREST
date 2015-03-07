package org.ghumasta.database;
import java.util.ArrayList;

/**
 * Created by YashGunapati1 on 3/7/15.
 */
public interface Database<T> {
    boolean connectToDatabase(String databaseName);
    boolean queryDatabase(String queryName);
    void insertData(ArrayList<T> dbObjects);

}
