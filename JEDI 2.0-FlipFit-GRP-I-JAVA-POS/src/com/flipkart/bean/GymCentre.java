package com.flipkart.bean;

public class GymCentre {

 private String centreId;
 private String ownerId;
 private String centreName;
 private String gstNo;
 private String city;
 private int capacity;
 private boolean isApproved;
 private int amountPerSlot;

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

    public int getAmountPerSlot() {
        return amountPerSlot;
    }

    public void setAmountPerSlot(int amountPerSlot) {
        this.amountPerSlot = amountPerSlot;
    }
}
