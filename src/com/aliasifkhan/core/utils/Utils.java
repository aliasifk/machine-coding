package com.aliasifkhan.core.utils;

import java.util.Arrays;

public class Utils {
    public static void log(Object... msg) {
        log("", Arrays.toString(msg));
    }

    public static void log(Object msg) {
        log("", msg);
    }

//    public static void log(String tag, Object msg) {
//
//        log(Application.LOG_DEBUG, tag, msg);
//    }

//    public static void log(int loglevel, String tag, Object msg) {
//        if (msg == null) {
//            Gdx.app.error("Globals", "Null msg");
//            return;
//        }
//        switch (loglevel) {
//            case Application.LOG_DEBUG:
//                Gdx.app.debug(tag, msg.toString());
//                break;
//            case Application.LOG_INFO:
//                Gdx.app.log(tag, msg.toString());
//                break;
//            case Application.LOG_ERROR:
//                Gdx.app.error(tag, msg.toString());
//                break;
//
//        }
//
//    }

}
