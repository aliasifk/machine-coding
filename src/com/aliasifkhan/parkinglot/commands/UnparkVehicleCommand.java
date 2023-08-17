package com.aliasifkhan.parkinglot.commands;

import com.aliasifkhan.parkinglot.Core;
import com.aliasifkhan.parkinglot.exceptions.*;

public class UnparkVehicleCommand extends Command{
    public UnparkVehicleCommand(int argsLength) {
        super(argsLength);
    }

    @Override
    public void execute(Core core, String[] command) throws ParkingLotOccupied, VehicleNotFound, VehicleNotSupported, InvalidTicket, CommandInvalidException {
        super.execute(core, command);
        String ticketId = command[1];
        if(!core.getTicketHashMap().containsKey(ticketId)){
            throw new InvalidTicket();
        }
        core.unparkVehicle(ticketId);
    }

}
