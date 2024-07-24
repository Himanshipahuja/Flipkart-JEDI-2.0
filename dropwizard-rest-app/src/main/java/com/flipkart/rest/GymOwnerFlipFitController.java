package com.flipkart.rest;

import com.flipkart.bean.GymOwner;
import com.flipkart.business.GymCenterServiceImpl;
import com.flipkart.business.GymCenterServiceInterface;
import com.flipkart.business.GymOwnerServiceImpl;
import com.flipkart.business.GymOwnerServiceInterface;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/gymOwner")
@Produces(MediaType.APPLICATION_JSON)
public class GymOwnerFlipFitController {

    GymOwnerServiceInterface gymOwnerService = new GymOwnerServiceImpl();
    GymCenterServiceInterface gymCenterService = new GymCenterServiceImpl();
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

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response GymOwnerRegister(GymOwner gymOwner) {
        GymOwner registerdGymOwner =  gymOwnerService.register(gymOwner);
        if(registerdGymOwner==null)
            return Response.notModified().build();
        return Response.ok(registerdGymOwner).build();
    }

    @GET
    @Path("/changePassword")
    @Produces(MediaType.APPLICATION_JSON)
    public String changePassword(@QueryParam("userName") String userName, @QueryParam("oldPassword") String oldPassword, @QueryParam("newPassword") String newPassword) {
        gymOwnerService.gymOwnerChangePassword(userName, oldPassword, newPassword);
        return "Password updated successfully.";
    }

    @GET
    @Path("/get-approval-owner")
    @Produces(MediaType.APPLICATION_JSON)
    public Response requestGymOwnerApproval(@QueryParam("gymOwnerId") String gymOwnerId) {
        gymOwnerService.requestGymOwnerApproval(gymOwnerId);
        return Response.ok("Sent approval request to Admin").build();
    }

    @GET
    @Path("/get-approval-center")
    @Produces(MediaType.APPLICATION_JSON)
    public Response requestGymCentreApproval(@QueryParam("gymCentreName") String gymCentreName, @QueryParam("userName") String userName) {
        gymCenterService.requestGymCentreApproval( gymCentreName, userName);
        return Response.ok("Sent Gym Center approval request to Admin").build();
    }
}
