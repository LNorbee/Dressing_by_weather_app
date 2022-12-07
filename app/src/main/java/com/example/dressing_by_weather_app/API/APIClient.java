package com.example.dressing_by_weather_app.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if (retrofit == null){
            //Retrofit.Builder class a Builder API-val teszi lehetővé
            // a HTTP műveletek URL végpontjának meghatározását,
            // majd egy új Retrofit példány létrehozását.
            retrofit = new Retrofit.Builder()
                    //https://api.openweathermap.org/data/2.5/weather?qSzeged&APPID={API key}
                    .baseUrl("https://api.openweathermap.org/data/2.5/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
