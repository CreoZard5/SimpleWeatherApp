package com.creolin.weather_application_using_api;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
Fragment FiveDayWeather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        URL accuweaterURL = NetworkUtil.buildURL();
        Log.i(TAG,"oncreate: "+ accuweaterURL);


        FiveDayWeather fiveDayWeather = new FiveDayWeather();

        FragmentManager fragmentManager5day = getSupportFragmentManager();
        FragmentTransaction transaction5day = fragmentManager5day.beginTransaction();
        transaction5day.replace(R.id.weather_frame,fiveDayWeather);
        transaction5day.commit();


        TidesWeather tidesWeather= new TidesWeather();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.tides_frame,tidesWeather);
        transaction.commit();

    }
}