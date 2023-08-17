package com.aliasifkhan.parkinglot.commands;

import com.aliasifkhan.parkinglot.Core;
import com.aliasifkhan.parkinglot.exceptions.*;

public abstract class Command {

    int argsLength;

    public Command(int argsLength) {
        this.argsLength = argsLength;
    }

    public void execute(Core core, String[] command) throws CommandInvalidException, ParkingLotOccupied, VehicleNotSupported, VehicleNotFound, InvalidTicket {
        if(command.length < argsLength){
            throw new CommandInvalidException();
        }
    }
}
