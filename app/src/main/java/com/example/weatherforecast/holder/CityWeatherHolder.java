package com.example.weatherforecast.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherforecast.R;
import com.example.weatherforecast.data.WeatherParameters;

public class CityWeatherHolder extends RecyclerView.ViewHolder {
    private TextView date;
    private TextView dayTemperature;
    private TextView nightTemperature;
    public CityWeatherHolder(@NonNull View itemView) {
        super(itemView);
        date = itemView.findViewById(R.id.date);
        dayTemperature = itemView.findViewById(R.id.day_temperature);
        nightTemperature = itemView.findViewById(R.id.night_temperature);
    }

    public void bind(WeatherParameters weatherParameters){
        date.setText(weatherParameters.getDate());
        dayTemperature.setText(weatherParameters.getDayTemperature());
        nightTemperature.setText(weatherParameters.getNightTemperature());
    }
}
