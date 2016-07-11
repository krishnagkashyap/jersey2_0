package org.hanbo.jersey.sample;

/**
 * Created by kgurupra on 5/2/2016.
 */

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

@Path("/hello")
public class HelloWorldService {
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public Response getMsg() throws IOException {
        Properties properties = new Properties();

        properties.load(HelloWorldService.class.getClassLoader().getResourceAsStream("properties/version.properties"));

        Response.ResponseBuilder responseBuilder = Response.ok();
        responseBuilder.entity(new Gson().toJson(properties));
        return responseBuilder.build();

    }
}