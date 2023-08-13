package com.aliasifkhan.parkinglot;

import java.util.ArrayList;
import java.util.UUID;

public class ParkingLot {
    private String id;
    private ArrayList<ParkingFloor> parkingFloors;

    public ParkingLot(int numberOfFloors, int numberOfSlotsPerFloor){
        parkingFloors = new ArrayList<>(numberOfFloors);
        for(int i = 0;i < numberOfFloors;i++){
            parkingFloors.add(new ParkingFloor(i + 1, numberOfSlotsPerFloor));
        }
    }
}
