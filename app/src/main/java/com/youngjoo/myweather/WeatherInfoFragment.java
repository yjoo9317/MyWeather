package com.youngjoo.myweather;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.io.IOException;

/**
 * Created by samsung on 2017. 5. 10..
 */

public class WeatherInfoFragment extends Fragment {
    private static final String TAG="WeatherInfoFragment";

    public static WeatherInfoFragment newInstance(){
        return new WeatherInfoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        new FetchInfoTask().execute();
    }


    private class FetchInfoTask extends AsyncTask<Void, Void, Void>{
        @Override
        protected Void doInBackground(Void...params){
            new WeatherFetcher().fetch();
            return null;
        }
    }
}
