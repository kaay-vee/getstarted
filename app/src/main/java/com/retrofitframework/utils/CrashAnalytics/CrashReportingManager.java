package com.igniva.framework.utils.CrashAnalytics;

import com.google.firebase.crash.FirebaseCrash;
import com.igniva.framework.BuildConfig;


public class CrashReportingManager {

    public static void logException(Exception e) {
        logException(e, false);
    }

    public static void logException(Exception e, boolean log) {
        if(BuildConfig.DEBUG){
            e.printStackTrace();
        } else if(log) {
            FirebaseCrash.report(e);
        }
    }
}
