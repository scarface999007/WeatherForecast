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
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherforecast.adapter.CityWeatherListAdapter;
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
    Data data;
    WeatherCity weatherCity;
    Button goToWikiBtn;
    Button goBack;
    RecyclerView cityTemperatureRecyclerView;

    private int id;

    public CityFragment(int id){
        this.id = id;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city, container, false);
        init(view, id);
        updateScreen(id);
        return view;
    }

    private void init(View view, int id){
        data = Data.getInstance();
        weatherCity = data.getWeatherCityById(id);
        city = view.findViewById(R.id.city);
        mainTemperature = view.findViewById(R.id.main_temperature);
        perceivedTemperature = view.findViewById(R.id.perceived_temperature);
        windSpeed = view.findViewById(R.id.wind_speed);
        atmospherePressure = view.findViewById(R.id.atmosphere_pressure);
        humidity = view.findViewById(R.id.humidity);
        cityTemperatureRecyclerView = view.findViewById(R.id.city_weather_recycler);
        cityTemperatureRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        cityTemperatureRecyclerView.addItemDecoration(new DividerItemDecoration(cityTemperatureRecyclerView.getContext(), DividerItemDecoration.VERTICAL));
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
            city.setText(weatherCity.getCity());
            mainTemperature.setText(currentDayParam.getDayTemperature());
            perceivedTemperature.setText(currentDayParam.getPerceivedTemperature());
            windSpeed.setText(currentDayParam.getWindPower());
            atmospherePressure.setText(currentDayParam.getPressure());
            humidity.setText(currentDayParam.getHumidity());
            cityTemperatureRecyclerView.setAdapter(new CityWeatherListAdapter(weatherCity));
        }
    }

}
