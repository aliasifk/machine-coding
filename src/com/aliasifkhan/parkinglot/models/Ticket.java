package com.aliasifkhan.parkinglot.models;

public class Ticket {

    private String id;
    private Vehicle vehicle;
    private String parkingLotId;
    private int floorNumber;
    private int slotNumber;

    private boolean isExpired;

    public Ticket(String parkingLotId, int floorNumber, int slotNumber, Vehicle vehicle){
        this.id = parkingLotId+"_"+floorNumber+"_"+slotNumber;
        this.floorNumber = floorNumber;
        this.parkingLotId = parkingLotId;
        this.slotNumber = slotNumber;
        this.vehicle = vehicle;
        this.isExpired = false;
    }

    public String getId() {
        return id;
    }


    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public boolean hasExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }
}
