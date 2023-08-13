package com.aliasifkhan.parkinglot;

import java.util.UUID;

public class Vehicle {
    private String id;
    private String reg_no;
    private String color;

    private VehicleType vehicleType;

    public Vehicle(){
    }

    public enum VehicleType{
        Car, Bike, Truck
    }


}
