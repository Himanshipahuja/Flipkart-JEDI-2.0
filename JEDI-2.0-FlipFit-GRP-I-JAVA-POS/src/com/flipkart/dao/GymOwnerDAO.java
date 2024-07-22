package com.flipkart.dao;
import com.flipkart.bean.GymOwner;

import java.util.List;

/**
 * Interface for GymOwner Data Access Object (DAO).
 */
public interface GymOwnerDAO {
    /**
     * Retrieves a list of GymOwner objects.
     *
     * @return a list of GymOwner objects
     */
    public List<GymOwner> getGymOwnerList();

    /**
     * Sets the list of GymOwner objects.
     *
     * @param gymOwnerList the list of GymOwner objects
     */
    public void setGymOwnerList(List<GymOwner> gymOwnerList);

    /**
     * Registers a new GymOwner with the given credentials.
     *
     * @param  userName   the username of the GymOwner
     * @param  password   the password of the GymOwner
     * @param  email      the email of the GymOwner
     * @param  panNumber  the PAN number of the GymOwner
     * @param  cardNumber the card number of the GymOwner
     * @return            the registered GymOwner object
     */
    public GymOwner registerGymOwner(String userName,String password,String email,String panNumber,String cardNumber);

    /**
     * Retrieves a list of pending GymOwner objects.
     *
     * @return          a list of pending GymOwner objects
     */
    public List<GymOwner> getPendingGymOwnerList();

    /**
     * Retrieves a list of approved GymOwner objects.
     *
     * @return          a list of approved GymOwner objects
     */
    public boolean loginGymOwner(String username,String password);

    /**
     * Sends a request for approval for a gym owner.
     *
     * @param  gymOwnerId   the ID of the gym owner
     */
    public void sendOwnerApprovalRequest(String gymOwnerId);

    /**
     * Retrieves the ID of a GymOwner with the given credentials.
     *
     * @param  userName   the username of the GymOwner
     * @param  password   the password of the GymOwner
     * @return            the ID of the GymOwner
     */
    public String getGymOwnerId(String userName, String password);

    /**
     * Retrieves a list of GymOwner objects.
     *
     * @return          a list of GymOwner objects
     */
    List<GymOwner> getGymOwnersList();

    /**
     * Validates all GymOwner objects.
     */
    public void validateAllGymOwners();

    /**
     * Validates a GymOwner with the given ID.
     *
     * @param  ownerId    the ID of the GymOwner
     * @param  isApproved the approval status of the GymOwner
     */
    public void validateGymOwnerByID(String ownerId, int isApproved);
}
