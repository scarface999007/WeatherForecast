package com.example.weatherforecast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.weatherforecast.adapter.CityChooseListAdapter;
import com.example.weatherforecast.data.Data;
import com.example.weatherforecast.data.WeatherCity;
import com.example.weatherforecast.data.WeatherParameters;

import java.util.ArrayList;

public class ChooseCityFragment extends Fragment {

    private LinearLayout linearLayout;
    private Data data;
    private ArrayList<WeatherCity> weatherCities;
    RecyclerView cityChooseRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose_city, container, false);
        init();
        RecyclerView cityChooseRecyclerView = view.findViewById(R.id.city_choose_recycler);
        cityChooseRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        cityChooseRecyclerView.setAdapter(new CityChooseListAdapter(weatherCities, getFragmentManager().beginTransaction()));
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.options_menu, menu);
    }

    public void init(){
        weatherCities = new ArrayList<>();
        WeatherParameters paramMsc1 = new WeatherParameters("29 июня", "+28", "+8", "Ощущается как +18", "Ветер: 4 м/с, СВ", "Давление: 745 мм рт. ст.", "Влажность: 40%");
        WeatherParameters paramMsc2 = new WeatherParameters("30 июня", "+26", "+9", "Ощущается как +16", "Ветер: 5 м/с, СВ", "Давление: 743 мм рт. ст.", "Влажность: 43%");
        WeatherParameters paramMsc3 = new WeatherParameters("1 июля", "+24", "+9", "Ощущается как +17", "Ветер: 3 м/с, СВ", "Давление: 742 мм рт. ст.", "Влажность: 41%");
        WeatherCity weatherMsc = new WeatherCity(1, "Москва", "+28");

        WeatherParameters paramL1 = new WeatherParameters("29 июня", "+25", "+10", "Ощущается как +18", "Ветер: 4 м/с, СВ", "Давление: 745 мм рт. ст.", "Влажность: 40%");
        WeatherParameters paramL2 = new WeatherParameters("30 июня", "+22", "+12", "Ощущается как +16", "Ветер: 5 м/с, СВ", "Давление: 743 мм рт. ст.", "Влажность: 43%");
        WeatherParameters paramL3 = new WeatherParameters("1 июля", "+20", "+10", "Ощущается как +17", "Ветер: 3 м/с, СВ", "Давление: 742 мм рт. ст.", "Влажность: 41%");
        WeatherCity weatherLondon = new WeatherCity(2, "Лондон", "+25");

        WeatherParameters paramT1 = new WeatherParameters("29 июня", "+27", "+14", "Ощущается как +18", "Ветер: 4 м/с, СВ", "Давление: 745 мм рт. ст.", "Влажность: 40%");
        WeatherParameters paramT2 = new WeatherParameters("30 июня", "+28", "+15", "Ощущается как +16", "Ветер: 5 м/с, СВ", "Давление: 743 мм рт. ст.", "Влажность: 43%");
        WeatherParameters paramT3 = new WeatherParameters("1 июля", "+29", "+16", "Ощущается как +17", "Ветер: 3 м/с, СВ", "Давление: 742 мм рт. ст.", "Влажность: 41%");
        WeatherCity weatherTokio = new WeatherCity(3, "Токио", "+27");

        weatherMsc.getWeatherParameters().add(paramMsc1);
        weatherMsc.getWeatherParameters().add(paramMsc2);
        weatherMsc.getWeatherParameters().add(paramMsc3);
        weatherLondon.getWeatherParameters().add(paramL1);
        weatherLondon.getWeatherParameters().add(paramL2);
        weatherLondon.getWeatherParameters().add(paramL3);
        weatherTokio.getWeatherParameters().add(paramT1);
        weatherTokio.getWeatherParameters().add(paramT2);
        weatherTokio.getWeatherParameters().add(paramT3);

        weatherCities.add(weatherMsc);
        weatherCities.add(weatherLondon);
        weatherCities.add(weatherTokio);

        data = Data.getInstance();
        data.setWeatherCities(weatherCities);
    }

}
