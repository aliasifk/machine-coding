package com.aliasifkhan.parkinglot.commands;

import com.aliasifkhan.parkinglot.Core;
import com.aliasifkhan.parkinglot.exceptions.*;
import com.aliasifkhan.parkinglot.models.Vehicle;

public class ParkVehicleCommand extends Command{

    public ParkVehicleCommand(int argsLength) {
        super(argsLength);
    }

    @Override
    public void execute(Core core, String[] command) throws CommandInvalidException, ParkingLotOccupied, VehicleNotSupported, VehicleNotFound, InvalidTicket {
            super.execute(core, command);
            Vehicle.VehicleType vehicleType = core.getVehicleValue(command[1]);
            String regNo = command[2];
            String color = command[3];
            core.parkVehicle(vehicleType, regNo, color);
    }

}
