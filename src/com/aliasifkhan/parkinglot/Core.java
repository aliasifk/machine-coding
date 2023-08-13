package com.aliasifkhan.parkinglot;

import com.aliasifkhan.core.utils.CommandProcesser;
import com.aliasifkhan.core.utils.Logger;

import java.util.HashMap;
import java.util.NoSuchElementException;

import static com.aliasifkhan.core.utils.Logger.getLogger;

public class Core {
    private HashMap<String, ParkingLot> parkingLotHashMap;

    private boolean isRunning;

    public void init(){
        parkingLotHashMap = new HashMap<>();
        isRunning = true;
    }

    public void run(){
        while(isRunning){
            String[] command = CommandProcesser.getCommandProcesser().readCommand();
            resolveCommand(command);
        }
    }

    public void createParkingLot(String parkingLotId, int numberOfFloors, int numberOfSlots){
        parkingLotHashMap.put(parkingLotId, new ParkingLot(parkingLotId, numberOfFloors, numberOfSlots));
        getLogger().log(Logger.LogLevel.DEBUG,"Parking Lot Created!");
    }

    public void parkVehicle(Vehicle.VehicleType vehicleType, String regNo, String color){
        getLogger().log("Vehicle Parked!");
    }

    public void unParkVehicle(String ticketId){
        getLogger().log("Vehicle Unparked!");
    }

    public void displayFreeCount(Vehicle.VehicleType vehicleType){
        getLogger().log("Vehicle Unparked!");
    }

    public void displayFreeSlots(Vehicle.VehicleType vehicleType){
        getLogger().log("Vehicle Unparked!");
    }

    public void displayOccupiedSlots(Vehicle.VehicleType vehicleType){
        getLogger().log("Vehicle Unparked!");
    }

    private void resolveCommand(String[] command){
        if(command.length ==0){
            invalidCommand();
        }
        String commandName = command[0];

        try{
            if(commandName.equalsIgnoreCase("create_parking_lot")  && command.length >= 4){
                String parkingLotId = command[1];
                int numberOfFloors = Integer.parseInt(command[2]);
                int numberOfSlots = Integer.parseInt(command[3]);
                createParkingLot(parkingLotId, numberOfFloors, numberOfSlots);

            }else if(commandName.equalsIgnoreCase("park_vehicle") && command.length >= 4){

                Vehicle.VehicleType vehicleType = getVehicleValue(command[1]);
                String regNo = command[2];
                String color = command[3];

                parkVehicle(vehicleType, regNo, color);

            }else if(commandName.equalsIgnoreCase("unpark_vehicle") && command.length >= 2){

                String ticketId = command[1];
                unParkVehicle(ticketId);

            }
            else if(commandName.equalsIgnoreCase("display")  && command.length >= 3){
                String displayType = command[1];
                Vehicle.VehicleType vehicleType = getVehicleValue(command[2]);


                if(displayType.equalsIgnoreCase("free_count")){
                    displayFreeCount(vehicleType);
                }else if(displayType.equalsIgnoreCase("free_slots")){
                    displayFreeSlots(vehicleType);
                }else if(displayType.equalsIgnoreCase("occupied_slots")){
                    displayOccupiedSlots(vehicleType);
                }

            }else if(commandName.equalsIgnoreCase("exit")){
                isRunning = false;
            }else{
                invalidCommand();
            }

        }catch (NumberFormatException e){
            getLogger().log("The arguments are invalid for command: ", commandName);
        }catch (NoSuchElementException e){
            getLogger().log("Vehicle Not Found", commandName);
        }
    }

    public void invalidCommand(){
        getLogger().log("Please enter a valid command");
    }

    public Vehicle.VehicleType getVehicleValue(String vehicle){
        for(Vehicle.VehicleType v: Vehicle.VehicleType.values()){
            if(v.toString().equalsIgnoreCase(vehicle))
                return v;
        }
        throw new NoSuchElementException();
    }

}
