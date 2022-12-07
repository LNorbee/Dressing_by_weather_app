package com.example.dressing_by_weather_app.API;

import com.example.dressing_by_weather_app.JsonData.DataModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("weather?APPID=eae7bc14fa0bbb62b02f6540171dd665&units=metric")
    Call<DataModel> getWeatherData(@Query("q") String cityName);
}
