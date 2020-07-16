package com.example.weatherforecast.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherforecast.R;
import com.example.weatherforecast.data.WeatherCity;
import com.example.weatherforecast.holder.CityWeatherHolder;

public class CityWeatherListAdapter extends RecyclerView.Adapter<CityWeatherHolder> {

    private WeatherCity weatherCity;

    public CityWeatherListAdapter(WeatherCity weatherCity){
        this.weatherCity = weatherCity;
    }


    @NonNull
    @Override
    public CityWeatherHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city_temperature, parent, false);
        return new CityWeatherHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CityWeatherHolder holder, int position) {
        holder.bind(weatherCity.getWeatherParameters().get(position));
    }

    @Override
    public int getItemCount() {
        return weatherCity.getWeatherParameters().size();
    }
}
