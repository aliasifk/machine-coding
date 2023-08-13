package com.aliasifkhan.parkinglot;

import com.aliasifkhan.core.utils.Application;

import static com.aliasifkhan.core.utils.Logger.getLogger;

public class ParkingLotApplication implements Application {

    @Override
    public void run() {
        getLogger().log("Running Parking Application......");
        while(true){

        }
    }

    @Override
    public void init() {
        getLogger().log("Initializing Parking Application......");
    }
}
