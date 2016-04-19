package com.yogi.spinginandroid;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.yogi.spinginandroid.dao.WeatherInfo;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            TextView greetingIdText = (TextView) findViewById(R.id.id_value);
            TextView greetingContentText = (TextView) findViewById(R.id.content_value);

        }
    }

}
