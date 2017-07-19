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

import java.util.List;

/**
 * Created by samsung on 2017. 5. 10..
 */

public class WeatherInfoFragment extends Fragment {
    private static final String TAG="WeatherInfoFragment";

    private RecyclerView mWeatherRecyclerView;
    private WeatherInfo mWeatherInfo;

    private WeatherAdapter mAdapter;

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

        //updateInfo();

        return v;
    }

    private void updateInfo(){
        List<WeatherInfoItem> list = mWeatherInfo.getWeatherInfoItems();
        Log.i(TAG, "PM25: "+list.get(4).getValue());
        mAdapter = new WeatherAdapter(list);
        mWeatherRecyclerView.setAdapter(mAdapter);
    }

    private class WeatherHolder extends RecyclerView.ViewHolder{

        public TextView mTitleTextView, mValueTextView;

        public WeatherHolder(View view){
            super(view);
            mTitleTextView = (TextView)view.findViewById(R.id.item_title_text);
            mValueTextView = (TextView)view.findViewById(R.id.item_value_text);
        }
    }

    private class WeatherAdapter extends RecyclerView.Adapter<WeatherHolder> {

        private List<WeatherInfoItem> mWeatherInfoItems;

        public WeatherAdapter(List<WeatherInfoItem> infos){
            mWeatherInfoItems = infos;
        }

        @Override
        public WeatherHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.list_info_item, parent, false);
            return new WeatherHolder(view);
        }

        @Override
        public void onBindViewHolder(WeatherHolder holder, int position){
            holder.mTitleTextView.setText(mWeatherInfoItems.get(position).getTitle());
            holder.mValueTextView.setText(mWeatherInfoItems.get(position).getValue());
        }

        @Override
        public int getItemCount(){
            return mWeatherInfoItems.size();
        }
    }

    private class FetchInfoTask extends AsyncTask<Void, Void, WeatherInfo>{
        @Override
        protected WeatherInfo doInBackground(Void...params){
            if(mWeatherInfo == null)
                mWeatherInfo = new WeatherInfo();
            new WeatherFetcher().fetchFromAirKorea(mWeatherInfo);
            //new WeatherFetcher().fetch();
            return mWeatherInfo;
        }

        @Override
        protected  void onPostExecute(WeatherInfo info){
            mWeatherInfo = info;
            updateInfo();
        }
    }


}
