package com.youngjoo.myweather;

/**
 * Created by samsung on 2017. 5. 16..
 */

public class WeatherInfo {

    private static final int COUNT = 9;
    private float mHighTemp;
    private float mLowTemp;
    private int mPM10Value;
    private int mPM10Grade;
    private int mPM25Value;
    private int mPM25Grade;
    private int mO3Value;
    private int mO3Grade;
    private String mStationName;

    public float getHighTemp() {
        return mHighTemp;
    }

    public void setHighTemp(float highTemp) {
        mHighTemp = highTemp;
    }

    public float getLowTemp() {
        return mLowTemp;
    }

    public void setLowTemp(float lowTemp) {
        mLowTemp = lowTemp;
    }

    public int getPM10Value() {
        return mPM10Value;
    }

    public void setPM10Value(int PM10Value) {
        mPM10Value = PM10Value;
    }

    public int getPM10Grade() {
        return mPM10Grade;
    }

    public void setPM10Grade(int PM10Grade) {
        mPM10Grade = PM10Grade;
    }

    public int getPM25Value() {
        return mPM25Value;
    }

    public void setPM25Value(int PM25Value) {
        mPM25Value = PM25Value;
    }

    public int getPM25Grade() {
        return mPM25Grade;
    }

    public void setPM25Grade(int PM25Grade) {
        mPM25Grade = PM25Grade;
    }

    public int getO3Value() {
        return mO3Value;
    }

    public void setO3Value(int o3Value) {
        mO3Value = o3Value;
    }

    public int getO3Grade() {
        return mO3Grade;
    }

    public void setO3Grade(int o3Grade) {
        mO3Grade = o3Grade;
    }

    public String getStationName() {
        return mStationName;
    }

    public void setStationName(String stationName) {
        mStationName = stationName;
    }

    public int getCount(){
        return COUNT;
    }
}
