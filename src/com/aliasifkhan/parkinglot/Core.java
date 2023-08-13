package com.aliasifkhan.parkinglot;

import com.aliasifkhan.core.utils.CommandProcesser;
import com.aliasifkhan.core.utils.Logger;
import com.aliasifkhan.parkinglot.exceptions.InvalidTicket;
import com.aliasifkhan.parkinglot.exceptions.ParkingLotOccupied;
import com.aliasifkhan.parkinglot.exceptions.VehicleNotFound;
import com.aliasifkhan.parkinglot.exceptions.VehicleNotSupported;

import java.util.HashMap;
import java.util.NoSuchElementException;

import static com.aliasifkhan.core.utils.Logger.getLogger;

public class Core {
    private HashMap<String, ParkingLot> parkingLotHashMap;
    private HashMap<String, Ticket> ticketHashMap;

    public static String ASSUMED_PARKING_LOT;
    private boolean isRunning;

    public void init(){
        parkingLotHashMap = new HashMap<>();
        ticketHashMap = new HashMap<>();
        isRunning = true;
    }

    public void run(){
        System.out.println("Enter a command: ");
        while(isRunning){
            String[] command = CommandProcesser.getCommandProcesser().readCommand();
            resolveCommand(command);
        }
    }

    public void createParkingLot(String parkingLotId, int numberOfFloors, int numberOfSlots){
        ASSUMED_PARKING_LOT = parkingLotId;
        parkingLotHashMap.put(parkingLotId, new ParkingLot(parkingLotId, numberOfFloors, numberOfSlots));
        getLogger().log(Logger.LogLevel.DEBUG,"Parking Lot Created!");
    }


    public void parkVehicle(Vehicle.VehicleType vehicleType, String regNo, String color) throws ParkingLotOccupied, VehicleNotSupported {
        Ticket ticket = parkingLotHashMap.get(ASSUMED_PARKING_LOT).parkVehicle(new Vehicle(vehicleType, regNo, color));
        ticketHashMap.put(ticket.getId(), ticket);
        getLogger().log("Vehicle Parked! with ticket id: ", ticket.getId());
    }

    public void unparkVehicle(String ticketId){
        parkingLotHashMap.get(ASSUMED_PARKING_LOT).unparkVehicle(ticketHashMap.get(ticketId));
        ticketHashMap.remove(ticketId);
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
        if(command.length == 0){
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
                if(!ticketHashMap.containsKey(ticketId)){
                    throw new InvalidTicket();
                }
                unparkVehicle(ticketId);

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
        }catch (VehicleNotFound e){
            getLogger().log("Vehicle Not Found", commandName);
        }catch (ParkingLotOccupied e){
            getLogger().log("Parking Lot Occupied!", commandName);
        } catch (InvalidTicket e) {
            getLogger().log("Ticket not found or expired", commandName);
        }catch (VehicleNotSupported e) {
            getLogger().log("Vehicle not supported", commandName);
        }

    }

    public void invalidCommand(){
        getLogger().log("Please enter a valid command");
    }

    public Vehicle.VehicleType getVehicleValue(String vehicle) throws VehicleNotFound {
        for(Vehicle.VehicleType v: Vehicle.VehicleType.values()){
            if(v.toString().equalsIgnoreCase(vehicle))
                return v;
        }
        throw new VehicleNotFound();
    }

}
