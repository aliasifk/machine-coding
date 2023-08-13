package com.aliasifkhan.parkinglot;

import com.aliasifkhan.core.utils.Application;
import com.aliasifkhan.core.utils.CommandProcesser;
import com.aliasifkhan.core.utils.Logger;

import static com.aliasifkhan.core.utils.CommandProcesser.getCommandProcesser;
import static com.aliasifkhan.core.utils.Logger.getLogger;

public class ParkingLotApplication implements Application {

    Core core;
    @Override
    public void run() {
        getLogger().log("Running Parking Application......");
        core.run();
    }

    @Override
    public void init() {
        getLogger().log("Initializing Parking Application......");
        getLogger().setLevel(Logger.LogLevel.DEBUG);
        core = new Core();
    }

    @Override
    public void dispose() {
        getCommandProcesser().dispose();
    }
}
