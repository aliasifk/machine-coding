package com.aliasifkhan.parkinglot;

import java.util.ArrayList;

public class ParkingLot {
    private String id;
    private ArrayList<ParkingFloor> parkingFloors;

    public ParkingLot(String id, int numberOfFloors, int numberOfSlotsPerFloor){
        this.id = id;
        parkingFloors = new ArrayList<>(numberOfFloors);
        for(int i = 0;i < numberOfFloors;i++){
            parkingFloors.add(new ParkingFloor(i + 1, numberOfSlotsPerFloor));
        }
    }
}
