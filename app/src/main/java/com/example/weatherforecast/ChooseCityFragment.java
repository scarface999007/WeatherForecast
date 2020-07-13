package com.example.weatherforecast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.weatherforecast.data.Data;
import com.example.weatherforecast.data.WeatherCity;
import com.example.weatherforecast.data.WeatherParameters;

public class ChooseCityFragment extends Fragment {

    private LinearLayout linearLayout;
    private Data data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose_city, container, false);
        init();
        linearLayout = view.findViewById(R.id.first_city);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CityActivity.changeFragment(new CityFragment(), getFragmentManager().beginTransaction());
            }
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.options_menu, menu);
    }

    public void init(){
        WeatherParameters param1 = new WeatherParameters("29 июня", "+28", "+8", "Ощущается как +18", "Ветер: 4 м/с, СВ", "Давление: 745 мм рт. ст.", "Влажность: 40%");
        WeatherParameters param2 = new WeatherParameters("30 июня", "+26", "+9", "Ощущается как +16", "Ветер: 5 м/с, СВ", "Давление: 743 мм рт. ст.", "Влажность: 43%");
        WeatherParameters param3 = new WeatherParameters("1 июля", "+24", "+9", "Ощущается как +17", "Ветер: 3 м/с, СВ", "Давление: 742 мм рт. ст.", "Влажность: 41%");
        WeatherCity weatherCity = new WeatherCity(1, "Москва");
        weatherCity.getWeatherParameters().add(param1);
        weatherCity.getWeatherParameters().add(param2);
        weatherCity.getWeatherParameters().add(param3);
        data = Data.getInstance();
        data.setWeatherCity(weatherCity);
    }

}
