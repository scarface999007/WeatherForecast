package com.example.weatherforecast.data;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private static Data instance;

    private ArrayList<WeatherCity> weatherCities;

    public static Data getInstance(){
        if(instance == null) {
            instance = new Data();
        }
        return instance;
    }

    public ArrayList<WeatherCity> getWeatherCities() {
        return weatherCities;
    }

    public void setWeatherCities(ArrayList<WeatherCity> weatherCities) {
        this.weatherCities = weatherCities;
    }

    public WeatherCity getWeatherCityById(int id){
        return weatherCities.get(id - 1);
    }
}
