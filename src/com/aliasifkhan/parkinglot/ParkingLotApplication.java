package com.aliasifkhan.parkinglot;

import com.aliasifkhan.core.utils.Application;
import com.aliasifkhan.core.utils.CommandProcesser;
import com.aliasifkhan.core.utils.Logger;

import static com.aliasifkhan.core.utils.CommandProcesser.getCommandProcesser;
import static com.aliasifkhan.core.utils.Logger.getLogger;

public class ParkingLotApplication implements Application {

    Core core;

    @Override
    public void init() {
        getLogger().setLevel(Logger.LogLevel.DEBUG);
        getLogger().log(Logger.LogLevel.INFO,"Initializing Parking Application......");
        core = new Core();
        core.init();
    }

    @Override
    public void run() {
        getLogger().log(Logger.LogLevel.INFO,"Running Parking Application......");
        core.run();
    }

    @Override
    public void dispose() {
        getCommandProcesser().dispose();
    }
}
