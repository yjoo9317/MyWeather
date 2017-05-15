package com.youngjoo.myweather;

import android.net.Uri;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by samsung on 2017. 5. 10..
 */

public class WeatherFetcher {

    private static final String APP_KEY="46d979b1-7eeb-3eee-ac3a-af6d1c98e8c3";
    private static final String SERVICE_KEY="QtxQoigSv7WX2WSBh7AIeNGZF3HrGc74pFYOHHa1dlEn%2BdKEMTWHvJzfr3uI3K4ii0qmJ0GgLOfYB7BeSzm6jg%3D%3D";
    private static final String AIR_QUALITY_URI="http://apis.skplanetx.com/weather/airquality/current";
    private static final String WEATHER_URI="http://apis.skplanetx.com/weather/current/minutely";
    private static final String AIR_QUALITY_BY_STATION_URI=" http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty";
    private static final String TAG="WeatherFetcher";
    private static final String LAT="37.274292";
    private static final String LON="127.076833";

    public void fetch(){
        try{
            String url = Uri.parse(WEATHER_URI).buildUpon()
                    .appendQueryParameter("version", "1")
                    .appendQueryParameter("lat", LAT)
                    .appendQueryParameter("lon", LON)
                    .appendQueryParameter("appKey", APP_KEY)
                    .build().toString();
            String jsonStr = getResString(url);
            Log.i(TAG, "Received JSON: "+jsonStr);
        } catch (IOException ioe){
            Log.e(TAG, "Failed to fetch: "+ioe);
        }
    }

    public void fetchFromAirKorea(){
        try{
            String url = Uri.parse(AIR_QUALITY_BY_STATION_URI).buildUpon()
                    .appendQueryParameter("ServiceKey", SERVICE_KEY)
                    .appendQueryParameter("ver", "1.3")
                    .appendQueryParameter("stationName", "광교동")
                    .appendQueryParameter("_returnType", "json")
                    .build().toString();
            String jsonResult = getResString(url);
            Log.i(TAG, "Received JSON from air korea: "+jsonResult);
        } catch(IOException ioe){
            Log.e(TAG, "Failed to fetch from air korea: "+ioe);
        }
    }


    private String getResString(String url) throws IOException{
        return new String(getUrlBytes(url));
    }

    private byte[] getUrlBytes(String urlSpec) throws IOException{
        URL url = new URL(urlSpec);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try{
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = connection.getInputStream();

            if(connection.getResponseCode() != HttpURLConnection.HTTP_OK){
                throw new IOException("Connection failed("+urlSpec+"): "+connection.getResponseMessage());
            }
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while((bytesRead = in.read(buffer))> 0){
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            return out.toByteArray();
        } finally {
            connection.disconnect();
        }
    }

}
