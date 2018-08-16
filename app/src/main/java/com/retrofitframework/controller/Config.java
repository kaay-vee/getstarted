package com.igniva.framework.controller;


public class Config {


    static String GCM_PROJECT_NUMBER = "";
    static String BASE_URL = "";
    static AppMode appMode = AppMode.TEST;
    static public String getBaseURL() {
        init(appMode);
        return BASE_URL;
    }

    static public String getGCMProjectNumber() {

        init(appMode);

        return GCM_PROJECT_NUMBER;
    }

    /**
     * Initialize all the variable in this method
     *
     * @param appMode
     */
    public static void init(AppMode appMode) {

        switch (appMode) {
            case DEV:
                BASE_URL = " http://donatemate.ignivastaging.com";
//                GCM_PROJECT_NUMBER = "563232976573";
                break;

            case TEST:
                BASE_URL="http://buus.ignivastaging.com:3508";
               // BASE_URL="http://shootitdev.ignivastaging.com";
              //  BASE_URL="http://unijob.ignivastaging.com:8010";
                //BASE_URL = "http://app.guildist.com:8001";
//                GCM_PROJECT_NUMBER = "563232976573";
                break;

            case LIVE:
                BASE_URL = " http://donatemate.ignivastaging.com";
//                GCM_PROJECT_NUMBER = "563232976573";
                break;
        }

    }

    public enum AppMode {
        DEV, TEST, LIVE
    }

}
