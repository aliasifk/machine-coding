package com.aliasifkhan.parkinglot;

import java.util.ArrayList;

public class ParkingFloor {
    private int floorNumber;
    private ArrayList<ParkingSlot> parkingSlots;

    //temp
    public static final Vehicle.VehicleType[] assumption = {Vehicle.VehicleType.Truck, Vehicle.VehicleType.Bike, Vehicle.VehicleType.Bike, Vehicle.VehicleType.Car};

    public ParkingFloor(int floorNumber, int numberOfSlots){
        this.floorNumber = floorNumber;
        parkingSlots = new ArrayList<>(numberOfSlots);

        for(int i = 0;i < numberOfSlots;i++){
            parkingSlots.add(new ParkingSlot(i+1, assumption[Math.min(i, assumption.length - 1)]));
        }

    }

}
