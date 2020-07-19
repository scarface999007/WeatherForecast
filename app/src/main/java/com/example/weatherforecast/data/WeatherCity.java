package com.example.weatherforecast.data;

import java.util.ArrayList;

public class WeatherCity {
    private int id;
    private String city;
    private String currentTemperature;
    private ArrayList<WeatherParameters> weatherParameters;

    public WeatherCity(int id, String city, String currentTemperature){
        this.id = id;
        this.city = city;
        this.currentTemperature = currentTemperature;
        weatherParameters = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(String currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public ArrayList<WeatherParameters> getWeatherParameters() {
        return weatherParameters;
    }

    public void setWeatherParameters(ArrayList<WeatherParameters> weatherParameters) {
        this.weatherParameters = weatherParameters;
    }
}
