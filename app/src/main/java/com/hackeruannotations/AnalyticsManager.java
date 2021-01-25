package com.hackeruannotations;

import android.util.Log;

import androidx.annotation.StringDef;

import static com.hackeruannotations.AnalyticsManager.Analytics.HOME;
import static com.hackeruannotations.AnalyticsManager.Analytics.ON_BOARDING;
import static com.hackeruannotations.AnalyticsManager.Analytics.SETTINGS;
import static com.hackeruannotations.AnalyticsManager.Analytics.SIGN_UP;

/**
 * Created By dorso on 06/01/2021
 **/
class AnalyticsManager {

    public static void sendAnalytic(@Analytics String event) {
        //Here ill send the data to a remote server for analytic
        Log.d("TAG", event);
    }

    @StringDef({ON_BOARDING, SIGN_UP, HOME, SETTINGS})
    @interface Analytics {
        String ON_BOARDING = "onBoarding";
        String SIGN_UP = "signUp";
        String HOME = "HOME";
        String SETTINGS = "SETTINGS";
    }
}