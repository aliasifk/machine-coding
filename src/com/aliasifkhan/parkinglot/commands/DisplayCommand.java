package com.aliasifkhan.parkinglot.commands;

import com.aliasifkhan.parkinglot.Core;
import com.aliasifkhan.parkinglot.exceptions.*;
import com.aliasifkhan.parkinglot.models.Vehicle;

public class DisplayCommand extends Command{

    public DisplayCommand(int argsLength) {
        super(argsLength);
    }

    @Override
    public void executeThis(Core core, String[] command) throws CommandInvalidException, ParkingLotOccupied, VehicleNotSupported, VehicleNotFound, InvalidTicket  {
        String displayType = command[1];
        Vehicle.VehicleType vehicleType = core.getVehicleValue(command[2]);

        if(displayType.equalsIgnoreCase("free_count")){
            core.displayFreeCount(vehicleType);
        }else if(displayType.equalsIgnoreCase("free_slots")){
            core.displayOccupiedOrFreeSlots(vehicleType, false);
        }else if(displayType.equalsIgnoreCase("occupied_slots")){
            core.displayOccupiedOrFreeSlots(vehicleType, true);
        }
    }

}
