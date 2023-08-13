package com.aliasifkhan.parkinglot;

import com.aliasifkhan.parkinglot.exceptions.VehicleNotSupported;

import java.util.ArrayList;

import static com.aliasifkhan.core.utils.Logger.getLogger;

public class ParkingFloor {
    private int floorNumber;
    private ArrayList<ParkingSlot> parkingSlots;

    private int numberOfSlotsOccupied;

    //temp
    public static final Vehicle.VehicleType[] assumption = {Vehicle.VehicleType.Truck, Vehicle.VehicleType.Bike, Vehicle.VehicleType.Bike, Vehicle.VehicleType.Car};

    public ParkingFloor(int floorNumber, int numberOfSlots){
        this.floorNumber = floorNumber;
        parkingSlots = new ArrayList<>(numberOfSlots);

        for(int i = 0;i < numberOfSlots;i++){
            parkingSlots.add(new ParkingSlot(i+1, assumption[Math.min(i, assumption.length - 1)]));
        }
    }

    public boolean isOccupied(){
        return numberOfSlotsOccupied == parkingSlots.size();
    }

    public int parkVehicle(Vehicle vehicle) throws VehicleNotSupported {

        for(ParkingSlot slot:  parkingSlots){
            if(!slot.isOccupied()){
                slot.parkVehicle(vehicle);
                numberOfSlotsOccupied++;
                return slot.getSlotNumber();
            }
        }

        getLogger().log("Cannot find on this floor?");
        return 0;
    }

    public void unparkVehicle(int slotNumber){
        parkingSlots.get(slotNumber).unparkVehicle();
        numberOfSlotsOccupied--;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
