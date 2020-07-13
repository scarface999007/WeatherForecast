package com.example.weatherforecast;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.weatherforecast.data.Data;
import com.example.weatherforecast.data.WeatherCity;
import com.example.weatherforecast.data.WeatherParameters;

public class CityFragment extends Fragment {

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
    Button goBack;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city, container, false);
        init(view);
        updateScreen(1);
        return view;
    }

    private void init(View view){
        data = Data.getInstance();
        weatherCity = data.getWeatherCity();
        city = view.findViewById(R.id.city);
        mainTemperature = view.findViewById(R.id.main_temperature);
        perceivedTemperature = view.findViewById(R.id.perceived_temperature);
        windSpeed = view.findViewById(R.id.wind_speed);
        atmospherePressure = view.findViewById(R.id.atmosphere_pressure);
        humidity = view.findViewById(R.id.humidity);
        firstDate = view.findViewById(R.id.first_date);
        firstDayTemperature = view.findViewById(R.id.first_day_temperature);
        firstNightTemperature = view.findViewById(R.id.first_night_temperature);
        secondDate = view.findViewById(R.id.second_date);
        secondDayTemperature = view.findViewById(R.id.second_day_temperature);
        secondNightTemperature = view.findViewById(R.id.second_night_temperature);
        thirdDate = view.findViewById(R.id.third_date);
        thirdDayTemperature = view.findViewById(R.id.third_day_temperature);
        thirdNightTemperature = view.findViewById(R.id.third_night_temperature);
        goToWikiBtn = view.findViewById(R.id.go_to_wiki);
        goToWikiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToWiki(weatherCity.getCity());
            }
        });
        goBack = view.findViewById(R.id.go_back);
        //TODO: проверка changeFragment(), в дальнейшем переделать лучше.
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CityActivity.changeFragment(new ChooseCityFragment(), getFragmentManager().beginTransaction());
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

}
