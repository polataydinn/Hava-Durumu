package com.example.havaa_durumu;

import java.util.HashMap;

public abstract class Const {
    public static final String BASE_URL = "https://api.collectapi.com/";
    public static String CURRENT_CITY;
    public static Double LATITUTE;
    public static Double LONGITUTE;
    public static String CURRENT_STATUS;
    public static String CURRENT_WEATHER;
    public static String TOMORROW_STATUS;
    public static String DAYS_OF_WEEK1;
    public static String DAYS_OF_WEEK2;
    public static String DAYS_OF_WEEK3;
    public static String DAYS_OF_WEEK4;
    public static String DAYS_OF_WEEK5;
    public static String DAYS_OF_WEEK6;
    public static int SWITCH_CASE = 0;
    public static String CLOUDS = "Clouds";
    public static String CLEAR = "Clear";
    public static String RAIN = "Rain";
    public static HashMap STATUS_MAP = new HashMap();
    public static HashMap DAYS_MAP = new HashMap();


    public static void initClass(){
        STATUS_MAP.put(CLOUDS,"https://img.icons8.com/color/96/000000/partly-cloudy-day.png");
        STATUS_MAP.put(CLEAR,"https://img.icons8.com/color/96/000000/summer.png");
        STATUS_MAP.put(RAIN,"https://img.icons8.com/color/96/000000/rain.png");


    }
}

