package com.yogi.spinginandroid;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yogi.spinginandroid.dao.WeatherInfo;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ril on 4/29/16.
 */
public class SpingForAndroidFragment  extends Fragment{

    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sping_for_android,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mView = view;
        new HttpRequestTask().execute();

    }

    private class HttpRequestTask extends AsyncTask<Void, Void, WeatherInfo> {
        @Override
        protected WeatherInfo doInBackground(Void... params) {
            try {
                final String url = "http://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=f99f77ed5030610fd6a37aab0f1773cb&mode=json&units=metric&cnt=15";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                WeatherInfo weatherInfo = restTemplate.getForObject(url, WeatherInfo.class);
                return weatherInfo;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(WeatherInfo weatherInfo) {
            ((TextView)mView.findViewById(R.id.name_value)).setText(weatherInfo.getName());
        }
    }
}
