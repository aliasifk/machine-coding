package com.aliasifkhan.parkinglot.models;

public class Vehicle {
    private String regNo;
    private String color;

    private VehicleType vehicleType;

    public Vehicle(Vehicle.VehicleType vehicleType, String regNo, String color){
        this.vehicleType = vehicleType;
        this.color = color;
        this.regNo = regNo;
    }

    public enum VehicleType{
        Car, Bike, Truck
    }

    public String getRegNo() {
        return regNo;
    }

    public String getColor() {
        return color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
