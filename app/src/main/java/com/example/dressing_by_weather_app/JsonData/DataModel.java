package com.example.dressing_by_weather_app.JsonData;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataModel {

    @SerializedName("main")
    private Main main;

    @SerializedName("weather")
    private List<Weather> weatherList;

    public Main getMain() {
        return main;
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }
}
