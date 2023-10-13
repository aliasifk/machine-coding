package com.aliasifkhan.parkinglot.commands;

import com.aliasifkhan.parkinglot.Core;
import com.aliasifkhan.parkinglot.exceptions.*;

public class ExitCommand extends Command {
    public ExitCommand(int argsLength) {
        super(argsLength);
    }

    @Override
    public void executeThis(Core core, String[] command) throws InvalidTicket, CommandInvalidException, ParkingLotOccupied, VehicleNotFound, VehicleNotSupported {
        core.exitSystem();
    }

}
