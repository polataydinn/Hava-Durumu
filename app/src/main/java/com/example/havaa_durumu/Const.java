package com.example.havaa_durumu;

import java.util.HashMap;

public abstract class Const {
    public static final String BASE_URL = "https://api.collectapi.com/";
    public static String CURRENT_CITY;
    public static String CURRENT_STATUS;
    public static String TOMORROW_STATUS;
    public static String CLOUDS = "Clouds";
    public static String CLEAR = "Clear";
    public static String RAIN = "Rain";
    public static HashMap STATUS_MAP = new HashMap();

    public static void initClass(){
        STATUS_MAP.put(CLOUDS,"https://img.icons8.com/color/96/000000/partly-cloudy-day.png");
        STATUS_MAP.put(CLEAR,"https://img.icons8.com/color/96/000000/summer.png");
        STATUS_MAP.put(RAIN,"https://img.icons8.com/color/96/000000/rain.png");
    }
}

