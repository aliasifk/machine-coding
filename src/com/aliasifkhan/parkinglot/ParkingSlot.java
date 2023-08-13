package com.aliasifkhan.parkinglot;

public class ParkingSlot {

    private int slotNumber;
    private Vehicle.VehicleType supportedVehicleType;

    private Vehicle vehicle;

    public ParkingSlot(int slotNumber, Vehicle.VehicleType supportedVehicleType){
        this.slotNumber = slotNumber;
        this.supportedVehicleType = supportedVehicleType;
    }

    public boolean isOccupied(){
        return vehicle != null;
    }

    public void parkVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public int getSlotNumber() {
        return slotNumber;
    }
}
