package com.youngjoo.myweather;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samsung on 2017. 5. 10..
 */

public class WeatherInfoFragment extends Fragment {
    private static final String TAG="WeatherInfoFragment";

    private RecyclerView mWeatherRecyclerView;
    private List<WeatherInfoItem> mWeatherInfoItems = new ArrayList<>();
    //private TextView mJsonTextView;

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
        //View v = inflater.inflate(R.layout.fragment_weather_info, container, false);
        //mJsonTextView = (TextView)v.findViewById(R.id.json_text_view);
        View v = inflater.inflate(R.layout.fragment_weather_summary, container, false);
        mWeatherRecyclerView = (RecyclerView) v.findViewById(R.id.weather_recycler_view);
        mWeatherRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }

    private void setAdapter(){
        if(isAdded()) {
            mWeatherRecyclerView.setAdapter(new WeatherAdapter(mWeatherInfoItems));
        } else{
            Log.e(TAG, "Fragment hasn't been attached yet..");
        }
    }

    private class WeatherHolder extends RecyclerView.ViewHolder{

        public TextView mTitleTextView, mValueTextView;

        public WeatherHolder(View view){
            super(view);
            mTitleTextView = (TextView)view.findViewById(R.id.item_title_text);
            mValueTextView = (TextView)view.findViewById(R.id.item_value_text);
        }

        public void bindWeatherInfoItem(WeatherInfoItem item){
            mTitleTextView.setText(item.getTitle());
            mValueTextView.setText(item.getValue());
        }
    }

    private class WeatherAdapter extends RecyclerView.Adapter<WeatherHolder> {

        //private WeatherInfo mWeatherInfo;
        private List<WeatherInfoItem> mWeatherInfoList;

        public WeatherAdapter(List<WeatherInfoItem> items){
            mWeatherInfoList = items;
        }

        @Override
        public WeatherHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.list_info_item, parent, false);
            return new WeatherHolder(view);
        }

        @Override
        public void onBindViewHolder(WeatherHolder holder, int position){
            WeatherInfoItem item = mWeatherInfoList.get(position);
            holder.bindWeatherInfoItem(item);
        }

        @Override
        public int getItemCount(){
            return mWeatherInfoList.size();
        }
    }

    private class FetchInfoTask extends AsyncTask<Void, Void, List<WeatherInfoItem>>{
        @Override
        protected List<WeatherInfoItem> doInBackground(Void...params){
            return new WeatherFetcher().fetchFromAirKorea();
            //new WeatherFetcher().fetch();

        }

        @Override
        protected void onPostExecute(List<WeatherInfoItem> list){
            mWeatherInfoItems = list;
            setAdapter();
        }
    }


}
