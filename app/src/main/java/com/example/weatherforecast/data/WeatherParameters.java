package com.example.weatherforecast.data;

public class WeatherParameters{
    private String date;
    private String dayTemperature;
    private String nightTemperature;
    private String perceivedTemperature;
    private String windPower;
    private String pressure;
    private String humidity;

    public WeatherParameters(String date, String currentTemperature, String nightTemperature, String perceivedTemperature, String windPower, String pressure, String humidity){
        this.date = date;
        this.dayTemperature = currentTemperature;
        this.nightTemperature = nightTemperature;
        this.perceivedTemperature = perceivedTemperature;
        this.windPower = windPower;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public String getDayTemperature() {
        return dayTemperature;
    }

    public void setDayTemperature(String dayTemperature) {
        this.dayTemperature = dayTemperature;
    }

    public String getWindPower() {
        return windPower;
    }

    public void setWindPower(String windPower) {
        this.windPower = windPower;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNightTemperature() {
        return nightTemperature;
    }

    public void setNightTemperature(String nightTemperature) {
        this.nightTemperature = nightTemperature;
    }

    public String getPerceivedTemperature() {
        return perceivedTemperature;
    }

    public void setPerceivedTemperature(String perceivedTemperature) {
        this.perceivedTemperature = perceivedTemperature;
    }
}
