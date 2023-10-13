package com.aliasifkhan.parkinglot.commands;

import com.aliasifkhan.parkinglot.Core;
import com.aliasifkhan.parkinglot.exceptions.*;

import static com.aliasifkhan.core.utils.Logger.getLogger;

public class CreateParkingLotCommand extends Command{


    public CreateParkingLotCommand(int argsLength){
        super(argsLength);
    }

    @Override
    public void executeThis(Core core, String[] command) throws CommandInvalidException, ParkingLotOccupied, VehicleNotSupported, VehicleNotFound, InvalidTicket  {
        String parkingLotId = command[1];
        int numberOfFloors = Integer.parseInt(command[2]);
        int numberOfSlots = Integer.parseInt(command[3]);
        core.createParkingLot(parkingLotId, numberOfFloors, numberOfSlots);
    }
}
