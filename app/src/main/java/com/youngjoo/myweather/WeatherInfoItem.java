package com.youngjoo.myweather;

/**
 * Created by yjoo9_000 on 2017-05-21.
 */

public class WeatherInfoItem {

    private String mTitle;
    private String mValue;

    public WeatherInfoItem(String title, String value){
        mTitle = title;
        mValue = value;
    }


    public String getTitle() {
        return mTitle;
    }

    public String getValue() {
        return mValue;
    }
}
