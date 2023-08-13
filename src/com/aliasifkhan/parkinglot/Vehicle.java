package com.aliasifkhan.parkinglot;

import java.util.UUID;

public class Vehicle {
    private String reg_no;
    private String color;

    private VehicleType vehicleType;

    public Vehicle(Vehicle.VehicleType vehicleType, String regNo, String color){
        this.vehicleType = vehicleType;
        this.color = color;
        this.reg_no = regNo;
    }

    public enum VehicleType{
        Car, Bike, Truck
    }


}
