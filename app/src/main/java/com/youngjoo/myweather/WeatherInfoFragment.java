package com.youngjoo.myweather;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by samsung on 2017. 5. 10..
 */

public class WeatherInfoFragment extends Fragment {
    private static final String TAG="WeatherInfoFragment";

    private TextView mJsonTextView;

    public static WeatherInfoFragment newInstance(){
        return new WeatherInfoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        new FetchInfoTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_weather_info, container, false);
        mJsonTextView = (TextView)v.findViewById(R.id.json_text_view);

        return v;
    }


    private class FetchInfoTask extends AsyncTask<Void, Void, Void>{
        @Override
        protected Void doInBackground(Void...params){
            new WeatherFetcher().fetchFromAirKorea();
            //new WeatherFetcher().fetch();
            return null;
        }
    }
}
