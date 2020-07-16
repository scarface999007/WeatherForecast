package com.example.weatherforecast.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherforecast.R;
import com.example.weatherforecast.data.WeatherCity;
import com.example.weatherforecast.holder.CityChooseHolder;

import java.util.ArrayList;

public class CityChooseListAdapter  extends RecyclerView.Adapter<CityChooseHolder> {

    private ArrayList<WeatherCity> weatherCities;
    private FragmentTransaction fragmentTransaction;

    public CityChooseListAdapter(ArrayList<WeatherCity> weatherCities, FragmentTransaction fragmentTransaction){
        this.weatherCities = weatherCities;
        this.fragmentTransaction = fragmentTransaction;
    }

    @NonNull
    @Override
    public CityChooseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_choose_city, parent, false);
        return new CityChooseHolder(v, fragmentTransaction);
    }

    @Override
    public void onBindViewHolder(@NonNull CityChooseHolder holder, int position) {
        holder.bind(weatherCities.get(position));
    }

    @Override
    public int getItemCount() {
        return weatherCities.size();
    }
}
