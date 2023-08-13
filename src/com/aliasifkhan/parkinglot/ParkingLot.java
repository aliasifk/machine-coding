package com.aliasifkhan.parkinglot;

import com.aliasifkhan.parkinglot.exceptions.ParkingLotOccupied;
import com.aliasifkhan.parkinglot.exceptions.VehicleNotFound;

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

    public Ticket parkVehicle(Vehicle vehicle) throws ParkingLotOccupied {

        ParkingFloor parkableFloor = null;

        for(ParkingFloor f: parkingFloors){
            if(!f.isOccupied()){
                parkableFloor = f;
                break;
            }
        }
        if(parkableFloor == null || parkableFloor.isOccupied()){
            throw new ParkingLotOccupied();
        }
        int floorNumber = parkableFloor.getFloorNumber();
        int slotNumber = parkableFloor.parkVehicle(vehicle);

        return new Ticket(id, floorNumber, slotNumber, vehicle);

    }
}
