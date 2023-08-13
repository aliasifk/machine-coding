package com.aliasifkhan.parkinglot;

import com.aliasifkhan.parkinglot.exceptions.ParkingLotOccupied;
import com.aliasifkhan.parkinglot.exceptions.VehicleNotSupported;

import java.util.ArrayList;
import java.util.HashMap;

import static com.aliasifkhan.core.utils.Logger.getLogger;
import static com.aliasifkhan.parkinglot.Vehicle.VehicleType.*;

public class ParkingFloor {
    private int floorNumber;
    private ArrayList<ParkingSlot> parkingSlots;

    private HashMap<Vehicle.VehicleType, Integer> vehicleToOccupiedSlots;

    //temp
    public static final Vehicle.VehicleType[] assumption = {Truck, Vehicle.VehicleType.Bike, Vehicle.VehicleType.Bike, Vehicle.VehicleType.Car};

    public ParkingFloor(int floorNumber, int numberOfSlots){
        this.floorNumber = floorNumber;
        vehicleToOccupiedSlots = new HashMap<>();
        vehicleToOccupiedSlots.put(Truck, 0);
        vehicleToOccupiedSlots.put(Vehicle.VehicleType.Car, 0);
        vehicleToOccupiedSlots.put(Vehicle.VehicleType.Bike, 0);
        parkingSlots = new ArrayList<>(numberOfSlots);

        for(int i = 0;i < numberOfSlots;i++){
            parkingSlots.add(new ParkingSlot(i+1, assumption[Math.min(i, assumption.length - 1)]));
        }
    }

    public boolean isOccupied(Vehicle vehicle){
        switch (vehicle.getVehicleType()){
            case Truck:
                return vehicleToOccupiedSlots.get(Truck) == 1;
            case Bike:
                return vehicleToOccupiedSlots.get(Bike) == 2;
            case Car:
                return vehicleToOccupiedSlots.get(Car) == parkingSlots.size() - 3;
        }
        return false;
    }

    public int parkVehicle(Vehicle vehicle) throws VehicleNotSupported, ParkingLotOccupied {

        for(ParkingSlot slot:  parkingSlots){
            if(!slot.isOccupied() && slot.getSupportedVehicleType() == vehicle.getVehicleType()){
                slot.parkVehicle(vehicle);
                vehicleToOccupiedSlots.put(vehicle.getVehicleType(), vehicleToOccupiedSlots.getOrDefault(vehicle.getVehicleType(), 0) + 1);
                return slot.getSlotNumber();
            }
        }

        throw new ParkingLotOccupied();

    }

    public void unparkVehicle(int slotNumber){
        ParkingSlot slot = parkingSlots.get(slotNumber);
        Vehicle.VehicleType v = slot.getVehicle().getVehicleType();
        vehicleToOccupiedSlots.put(v, vehicleToOccupiedSlots.get(v) - 1);
        parkingSlots.get(slotNumber).unparkVehicle();

    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public ArrayList<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public HashMap<Vehicle.VehicleType, Integer> getVehicleToOccupiedSlots() {
        return vehicleToOccupiedSlots;
    }

}
