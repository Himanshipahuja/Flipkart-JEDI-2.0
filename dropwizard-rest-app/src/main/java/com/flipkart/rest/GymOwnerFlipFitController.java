package com.flipkart.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.*;
import com.flipkart.business.SlotServiceInterface;
import com.flipkart.business.*;
import com.flipkart.exceptions.DataEntryException;
import org.eclipse.jetty.http.MetaData;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Path("/gymowner")
@Produces(MediaType.APPLICATION_JSON)
public class GymOwnerFlipFitController {

    GymOwnerServiceInterface gymOwnerService = new GymOwnerServiceImpl();

    @GET
    @Path("/login")
    public String GymOwnerLogin(@QueryParam("userName") String userName, @QueryParam("password") String password) {
        boolean loggedIn = gymOwnerService.gymOwnerLogin(userName, password);
        if(loggedIn){
            return "Login successful! Credentials are matching";
        }
        else{
            return "Login failed! Invalid Credentials";
        }
    }
}
