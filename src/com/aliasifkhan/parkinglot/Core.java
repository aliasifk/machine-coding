package com.aliasifkhan.parkinglot;

import com.aliasifkhan.core.utils.CommandProcesser;
import com.aliasifkhan.core.utils.Logger;
import com.aliasifkhan.parkinglot.commands.*;
import com.aliasifkhan.parkinglot.exceptions.*;
import com.aliasifkhan.parkinglot.models.*;

import java.util.HashMap;

import static com.aliasifkhan.core.utils.Logger.getLogger;

public class Core {
    private HashMap<String, ParkingLot> parkingLotHashMap;
    private HashMap<String, Ticket> ticketHashMap;

    private HashMap<String, Command> commandHashMap;
    public static String ASSUMED_PARKING_LOT;
    private boolean isRunning;

    public void init(){
        parkingLotHashMap = new HashMap<>();
        ticketHashMap = new HashMap<>();
        commandHashMap = new HashMap<>();


        commandHashMap.put("create_parking_lot", new CreateParkingLotCommand(4));
        commandHashMap.put("park_vehicle", new ParkVehicleCommand(4));
        commandHashMap.put("unpark_vehicle", new UnparkVehicleCommand(2));
        commandHashMap.put("display", new DisplayCommand(3));
        commandHashMap.put("exit", new ExitCommand(1));


        isRunning = true;
    }

    public void run(){
        System.out.println("Enter a command: ");
        while(isRunning){
            String[] command = CommandProcesser.getCommandProcesser().readCommand();
            if(command.length == 0 || command[0].isEmpty() || command[0].equals("\n")){
                continue;
            }
            displayHR();
            resolveCommand(command);
        }
    }

    public void createParkingLot(String parkingLotId, int numberOfFloors, int numberOfSlots){
        ASSUMED_PARKING_LOT = parkingLotId;
        parkingLotHashMap.put(parkingLotId, new ParkingLot(parkingLotId, numberOfFloors, numberOfSlots));
        getLogger().log(Logger.LogLevel.INFO,"Parking Lot Created!: ", parkingLotId);
    }

    public void exitSystem(){
        this.isRunning = false;
    }


    public void parkVehicle(Vehicle.VehicleType vehicleType, String regNo, String color) throws ParkingLotOccupied, VehicleNotSupported {
        Ticket ticket = parkingLotHashMap.get(ASSUMED_PARKING_LOT).parkVehicle(new Vehicle(vehicleType, regNo, color));
        ticketHashMap.put(ticket.getId(), ticket);
        getLogger().log(Logger.LogLevel.INFO, "Vehicle Parked! with ticket id: ", ticket.getId());
    }

    public void unparkVehicle(String ticketId){
        parkingLotHashMap.get(ASSUMED_PARKING_LOT).unparkVehicle(ticketHashMap.get(ticketId));
        ticketHashMap.remove(ticketId);
        getLogger().log(Logger.LogLevel.INFO, "Vehicle Unparked! with ticket id: ", ticketId);
    }

    public void displayFreeCount(Vehicle.VehicleType vehicleType){
        for(ParkingFloor parkingFloor: parkingLotHashMap.get(ASSUMED_PARKING_LOT).getParkingFloors() ){
            getLogger().log(Logger.LogLevel.INFO,"No. of free slots for ", vehicleType," on ",parkingFloor.getFloorNumber(),": ", parkingFloor.getFreeSlotsForVehicle(vehicleType));
        }
    }

    public void displayOccupiedOrFreeSlots(Vehicle.VehicleType vehicleType, boolean displayOccupied){
        for(ParkingFloor parkingFloor: parkingLotHashMap.get(ASSUMED_PARKING_LOT).getParkingFloors() ){
            StringBuilder st = new StringBuilder();
            for(int i = 0;i < parkingFloor.getParkingSlots().size();i++){
                ParkingSlot parkingSlot = parkingFloor.getParkingSlots().get(i);
                if(parkingSlot.getSupportedVehicleType() == vehicleType &&  (parkingSlot.isOccupied() && displayOccupied || !parkingSlot.isOccupied() && !displayOccupied)){
                    st.append(i + 1).append(", ");
                }

            }
            getLogger().log(Logger.LogLevel.INFO, displayOccupied? "Occupied": "Free" ,"slots for ", vehicleType," on ",parkingFloor.getFloorNumber(),": ", st.toString());

        }
    }



    private void resolveCommand(String[] command){
        if(command.length == 0){
            invalidCommand();
        }
        String commandName = command[0];
        try {
            if(!commandHashMap.containsKey(commandName)){
                throw new CommandInvalidException();
            }
            commandHashMap.get(commandName).execute(this, command);
        }
        catch (CommandInvalidException | NumberFormatException e){
            getLogger().log(Logger.LogLevel.ERROR,"The arguments are invalid for command: ");
        }catch (VehicleNotFound e){
            getLogger().log(Logger.LogLevel.ERROR,"Vehicle Not Found");
        }catch (ParkingLotOccupied e){
            getLogger().log(Logger.LogLevel.ERROR,"Parking Lot Occupied!");
        } catch (InvalidTicket e) {
            getLogger().log(Logger.LogLevel.ERROR,"Ticket not found or expired");
        }catch (VehicleNotSupported e) {
            getLogger().log(Logger.LogLevel.ERROR,"Vehicle not supported");
        }
    }

    public void invalidCommand(){
        getLogger().log(Logger.LogLevel.ERROR, "Please enter a valid command");
    }
    public void displayHR(){
        getLogger().log(Logger.LogLevel.INFO,"----------------------------------------------------------------------");
    }

    public Vehicle.VehicleType getVehicleValue(String vehicle) throws VehicleNotFound {
        for(Vehicle.VehicleType v: Vehicle.VehicleType.values()){
            if(v.toString().equalsIgnoreCase(vehicle))
                return v;
        }
        throw new VehicleNotFound();
    }

    public HashMap<String, Ticket> getTicketHashMap() {
        return ticketHashMap;
    }
}