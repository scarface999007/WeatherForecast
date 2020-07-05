package com.example.weatherforecast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.weatherforecast.data.Data;
import com.example.weatherforecast.data.WeatherCity;
import com.example.weatherforecast.data.WeatherParameters;

public class ChooseCityActivity extends AppCompatActivity {

    private static final String TAG = "ChooseCityActivity";
    private LinearLayout linearLayout;
    private Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_city);
        Log.d(TAG, "onCreate");
        init();
        linearLayout = findViewById(R.id.first_city);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(CityActivity.getIntent(ChooseCityActivity.this, "id", data.getWeatherCity().getId()));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    public void init(){
        WeatherParameters param1 = new WeatherParameters("29 июня", "+28", "+8", "Ощущается как +18", "Ветер: 4 м/с, СВ", "Давление: 745 мм рт. ст.", "Влажность: 40%");
        WeatherParameters param2 = new WeatherParameters("30 июня", "+26", "+9", "Ощущается как +16", "Ветер: 5 м/с, СВ", "Давление: 743 мм рт. ст.", "Влажность: 43%");
        WeatherParameters param3 = new WeatherParameters("1 июля", "+24", "+9", "Ощущается как +17", "Ветер: 3 м/с, СВ", "Давление: 742 мм рт. ст.", "Влажность: 41%");
        WeatherCity weatherCity = new WeatherCity(1, "Москва");
        weatherCity.getWeatherParameters().add(param1);
        weatherCity.getWeatherParameters().add(param2);
        weatherCity.getWeatherParameters().add(param3);
        data = Data.getInstance();
        data.setWeatherCity(weatherCity);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

}