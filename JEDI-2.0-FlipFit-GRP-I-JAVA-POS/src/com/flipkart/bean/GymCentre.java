package com.flipkart.bean;

public class GymCentre {

     private String centreId;
     private String ownerId;
     private String centreName;
     private String gstNo;
     private String city;
     private int capacity;
     private boolean isApproved;
     private float amountPerSlot;

    public GymCentre() {
    }

    public GymCentre(String gymCentreID, String ownerID, String gymCenterName, String gstin, String city, int capacity, int price) {
        this.centreId = gymCentreID;
        this.ownerId = ownerID;
        this.centreName = gymCenterName;
        this.gstNo = gstin;
        this.city = city;
        this.capacity = capacity;
        this.amountPerSlot = price;
        this.isApproved = false;
    }

    public String getCentreId() {
        return centreId;
    }

    public void setCentreId(String centreId) {
        this.centreId = centreId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getCentreName() {
        return centreName;
    }

    public void setCentreName(String centreName) {
        this.centreName = centreName;
    }

    public String getGstNo() {
        return gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public float getAmountPerSlot() {
        return amountPerSlot;
    }

    public void setAmountPerSlot(float amountPerSlot) {
        this.amountPerSlot = amountPerSlot;
    }
}
