package com.aliasifkhan.parkinglot.commands;

import com.aliasifkhan.parkinglot.Core;
import com.aliasifkhan.parkinglot.exceptions.*;

public class ExitCommand extends Command {
    public ExitCommand(int argsLength) {
        super(argsLength);
    }

    @Override
    public void execute(Core core, String[] command) throws InvalidTicket, CommandInvalidException, ParkingLotOccupied, VehicleNotFound, VehicleNotSupported {
        super.execute(core, command);
        core.exitSystem();
    }

}
