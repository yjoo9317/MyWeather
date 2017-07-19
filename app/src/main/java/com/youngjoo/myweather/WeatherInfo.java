package com.youngjoo.myweather;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samsung on 2017. 5. 16..
 */

public class WeatherInfo {

    private static final String TAG="WeatherInfo";
    private static final int COUNT = 9;
    private static final String[] TITLES = {"High Temp", "Low Temp", "PM10 Value", "PM10 Grade",
                "PM2.5 Value", "PM2.5 Grade", "O3 Value", "O3 Grade", "Station"};
    private static String[] mValues;
    private float mHighTemp = 0;
    private float mLowTemp = 0;
    private int mPM10Value = 0;
    private int mPM10Grade = 0;
    private int mPM25Value = 0;
    private int mPM25Grade = 0;
    private int mO3Value = 0;
    private int mO3Grade = 0;
    private String mStationName ="test....";

    private List<WeatherInfoItem> mWeatherInfoItems;

    public WeatherInfo(){
        mWeatherInfoItems = new ArrayList<WeatherInfoItem>();
        mValues = new String[10];
    }

    public void createInfoList(){
        for(int i = 0; i < COUNT; i++){
            WeatherInfoItem item = new WeatherInfoItem(TITLES[i], mValues[i]);
            Log.i(TAG, "item<"+TITLES[i]+"> added.("+mValues[i]+")");
            mWeatherInfoItems.add(item);
        }
    }

    public List<WeatherInfoItem> getWeatherInfoItems() {
        return mWeatherInfoItems;
    }

    public float getHighTemp() {
        return mHighTemp;
    }

    public void setHighTemp(float highTemp) {
        mHighTemp = highTemp;
        mValues[0] = String.valueOf(mHighTemp);
    }

    public float getLowTemp() {
        return mLowTemp;
    }

    public void setLowTemp(float lowTemp) {
        mLowTemp = lowTemp;
        mValues[1] = String.valueOf(mLowTemp);
    }

    public int getPM10Value() {
        return mPM10Value;
    }

    public void setPM10Value(int PM10Value) {
        mPM10Value = PM10Value;
        mValues[2] = String.valueOf(mPM10Value);
    }

    public int getPM10Grade() {
        return mPM10Grade;
    }

    public void setPM10Grade(int PM10Grade) {
        mPM10Grade = PM10Grade;
        mValues[3] = String.valueOf(mPM10Grade);
    }

    public int getPM25Value() {
        return mPM25Value;
    }

    public void setPM25Value(int PM25Value) {
        mPM25Value = PM25Value;
        mValues[4] = String.valueOf(mPM25Value);
    }

    public int getPM25Grade() {
        return mPM25Grade;
    }

    public void setPM25Grade(int PM25Grade) {
        mPM25Grade = PM25Grade;
        mValues[5] = String.valueOf(mPM25Grade);
    }

    public int getO3Value() {
        return mO3Value;
    }

    public void setO3Value(int o3Value) {
        mO3Value = o3Value;
        mValues[6] = String.valueOf(mO3Value);
    }

    public int getO3Grade() {
        return mO3Grade;
    }

    public void setO3Grade(int o3Grade) {
        mO3Grade = o3Grade;
        mValues[7] = String.valueOf(mO3Grade);
    }

    public String getStationName() {
        return mStationName;
    }

    public void setStationName(String stationName) {
        mStationName = stationName;
        mValues[8] = mStationName;
    }

    public int getCount(){
        return COUNT;
    }
}
