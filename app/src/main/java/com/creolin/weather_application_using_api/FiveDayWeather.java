package com.creolin.weather_application_using_api;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.function.ToDoubleBiFunction;


public class FiveDayWeather extends Fragment {

    public FiveDayWeather() {

    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_five_day_weather, container, false);
        return view;
    }
}