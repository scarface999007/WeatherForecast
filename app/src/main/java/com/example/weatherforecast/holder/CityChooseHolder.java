package com.example.weatherforecast.holder;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherforecast.CityActivity;
import com.example.weatherforecast.CityFragment;
import com.example.weatherforecast.R;
import com.example.weatherforecast.data.WeatherCity;
import com.example.weatherforecast.data.WeatherParameters;

public class CityChooseHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView city;
    private TextView temperature;
    private WeatherCity weatherCityH;
    private FragmentTransaction fragmentTransaction;
    public CityChooseHolder(@NonNull View itemView, final FragmentTransaction fragmentTransaction) {
        super(itemView);
        this.fragmentTransaction = fragmentTransaction;
        city = itemView.findViewById(R.id.choose_city);
        temperature = itemView.findViewById(R.id.current_temperature);
        itemView.setOnClickListener(this);
    }

    public void bind(WeatherCity weatherCity){
        weatherCityH = weatherCity;
        city.setText(weatherCityH.getCity());
        temperature.setText(weatherCityH.getCurrentTemperature());
    }

    @Override
    public void onClick(View v) {
        CityActivity.changeFragment(new CityFragment(weatherCityH.getId()), fragmentTransaction);
    }
}
