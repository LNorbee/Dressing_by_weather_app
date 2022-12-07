package com.example.dressing_by_weather_app.JsonData;

import com.google.gson.annotations.SerializedName;

public class Main {
    // a SerializedName meg kell eggyezzen az OpenweatherMap
    // JSON fájljában szereplővel
    @SerializedName("temp")
    String temp;

    @SerializedName("humidity")
    String humidity;

    public String getTemp() {
        return temp;
    }

    public String getHumidity() {
        return humidity;
    }
}
