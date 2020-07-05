package com.example.weatherforecast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.weatherforecast.data.Data;
import com.example.weatherforecast.data.WeatherCity;
import com.example.weatherforecast.data.WeatherParameters;

public class CityActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    TextView city;
    TextView mainTemperature;
    TextView perceivedTemperature;
    TextView windSpeed;
    TextView atmospherePressure;
    TextView humidity;
    TextView firstDate;
    TextView firstDayTemperature;
    TextView firstNightTemperature;
    TextView secondDate;
    TextView secondDayTemperature;
    TextView secondNightTemperature;
    TextView thirdDate;
    TextView thirdDayTemperature;
    TextView thirdNightTemperature;
    Data data;
    WeatherCity weatherCity;
    Button goToWikiBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Log.d(TAG, "onCreate");
        int id = getIntent().getIntExtra("id", -1);
        updateScreen(id);
    }

    private void init(){
        data = Data.getInstance();
        weatherCity = data.getWeatherCity();
        city = findViewById(R.id.city);
        mainTemperature = findViewById(R.id.main_temperature);
        perceivedTemperature = findViewById(R.id.perceived_temperature);
        windSpeed = findViewById(R.id.wind_speed);
        atmospherePressure = findViewById(R.id.atmosphere_pressure);
        humidity = findViewById(R.id.humidity);
        firstDate = findViewById(R.id.first_date);
        firstDayTemperature = findViewById(R.id.first_day_temperature);
        firstNightTemperature = findViewById(R.id.first_night_temperature);
        secondDate = findViewById(R.id.second_date);
        secondDayTemperature = findViewById(R.id.second_day_temperature);
        secondNightTemperature = findViewById(R.id.second_night_temperature);
        thirdDate = findViewById(R.id.third_date);
        thirdDayTemperature = findViewById(R.id.third_day_temperature);
        thirdNightTemperature = findViewById(R.id.third_night_temperature);
        goToWikiBtn = findViewById(R.id.go_to_wiki);
        goToWikiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToWiki(weatherCity.getCity());
            }
        });
    }

    private void goToWiki(String city){
        Uri address = Uri.parse("https://ru.wikipedia.org/wiki/" + city);
        Intent linkIntent = new Intent(Intent.ACTION_VIEW, address);
        startActivity(linkIntent);
    }

    private void updateScreen(int id){
        if(weatherCity.getId() == id){
            WeatherParameters currentDayParam = weatherCity.getWeatherParameters().get(0);
            WeatherParameters param2 = weatherCity.getWeatherParameters().get(1);
            WeatherParameters param3 = weatherCity.getWeatherParameters().get(2);

            city.setText(weatherCity.getCity());
            mainTemperature.setText(currentDayParam.getDayTemperature());
            perceivedTemperature.setText(currentDayParam.getPerceivedTemperature());
            windSpeed.setText(currentDayParam.getWindPower());
            atmospherePressure.setText(currentDayParam.getPressure());
            humidity.setText(currentDayParam.getHumidity());
            firstDate.setText(currentDayParam.getDate());
            firstDayTemperature.setText(currentDayParam.getDayTemperature());
            firstNightTemperature.setText(currentDayParam.getNightTemperature());
            secondDate.setText(param2.getDate());
            secondDayTemperature.setText(param2.getDayTemperature());
            secondNightTemperature.setText(param2.getNightTemperature());
            thirdDate.setText(param3.getDate());
            thirdDayTemperature.setText(param3.getDayTemperature());
            thirdNightTemperature.setText(param3.getNightTemperature());
        }
    }

    public static Intent getIntent(Context context, String key, int id){
        Intent intent = new Intent(context, CityActivity.class);
        intent.putExtra(key, id);
        return intent;
    }

}