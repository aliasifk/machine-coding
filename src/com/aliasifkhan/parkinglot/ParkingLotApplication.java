package com.aliasifkhan.parkinglot;

import com.aliasifkhan.core.utils.Application;
import com.aliasifkhan.core.utils.CommandProcesser;
import com.aliasifkhan.core.utils.Logger;

import static com.aliasifkhan.core.utils.CommandProcesser.getCommandProcesser;
import static com.aliasifkhan.core.utils.Logger.getLogger;

public class ParkingLotApplication implements Application {

    @Override
    public void run() {
        getLogger().log("Running Parking Application......");
        while(true){
            String[] command = getCommandProcesser().readCommand();
            getLogger().log("Your Input: ",command[0]);

        }
    }

    @Override
    public void init() {
        getLogger().log("Initializing Parking Application......");
        getLogger().setLevel(Logger.LogLevel.DEBUG);
    }

    @Override
    public void dispose() {
        getCommandProcesser().dispose();
    }
}
