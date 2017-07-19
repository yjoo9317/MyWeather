package com.youngjoo.myweather;

/**
 * Created by samsung on 2017. 5. 19..
 */

public class WeatherInfoItem {
    private String mTitle;
    private String mValue;

    public String getTitle() {
        return mTitle;
    }

    public String getValue() {
        return mValue;
    }

    public WeatherInfoItem(String title, String value){
        mTitle = title;
        mValue = value;
    }


}
