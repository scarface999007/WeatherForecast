package com.example.weatherforecast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.weatherforecast.data.Data;
import com.example.weatherforecast.data.WeatherCity;
import com.example.weatherforecast.data.WeatherParameters;

public class CityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if(fragment == null){
            fragment = new ChooseCityFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }


    public static Intent getIntent(Context context, String key, int id){
        Intent intent = new Intent(context, CityActivity.class);
        intent.putExtra(key, id);
        return intent;
    }

    //TODO: в дальнейшем переделать по лучше и с передачей данных.
    public static void changeFragment(Fragment fragment, FragmentTransaction ft){
        ft.replace(R.id.fragment_container, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}
