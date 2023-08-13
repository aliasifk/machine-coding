package com.aliasifkhan.parkinglot;

import com.aliasifkhan.parkinglot.exceptions.VehicleNotSupported;

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

    public void parkVehicle(Vehicle vehicle) throws VehicleNotSupported {
        if(supportedVehicleType != vehicle.getVehicleType()){
            throw new VehicleNotSupported();
        }
        this.vehicle = vehicle;
    }

    public void unparkVehicle(){
        vehicle = null;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public Vehicle.VehicleType getSupportedVehicleType() {
        return supportedVehicleType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
