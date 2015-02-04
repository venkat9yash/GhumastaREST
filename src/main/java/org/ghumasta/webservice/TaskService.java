package org.ghumasta.webservice;

/**
 * Created by YashGunapati1 on 2/1/15.
 */


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.ghumasta.models.Task;

import java.sql.Timestamp;

@Path("/Task")
public class TaskService {
    @GET
    @Path("/Default")
    @Produces("application/json")
    public Task defaultTask(){
        Task task = new Task("Default Task Created");
        return task;
    }
}
