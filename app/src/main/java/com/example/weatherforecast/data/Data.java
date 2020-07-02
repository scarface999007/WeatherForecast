package com.example.weatherforecast.data;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private static Data instance;

    private WeatherCity weatherCity;

    public static Data getInstance(){
        if(instance == null) {
            instance = new Data();
        }
        return instance;
    }

    public WeatherCity getWeatherCity() {
        return weatherCity;
    }

    public void setWeatherCity(WeatherCity weatherCity) {
        this.weatherCity = weatherCity;
    }
}
