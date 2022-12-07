package com.example.dressing_by_weather_app;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dressing_by_weather_app.API.APIClient;
import com.example.dressing_by_weather_app.API.APIInterface;
import com.example.dressing_by_weather_app.JsonData.DataModel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity<temp> extends AppCompatActivity {

    EditText etSearchCity;
    Button btnSearch;
    Button btnGPS;
    TextView tvResultTemp;

    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        etSearchCity = findViewById(R.id.etSearchCity);
        btnSearch = findViewById(R.id.btnSearch);
        btnGPS = findViewById(R.id.btnGPS);
        tvResultTemp = findViewById(R.id.tvResultTemp);

        btnSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                getWeatherData(etSearchCity.getText().toString().trim());
                hideSoftKeyboard(HomeActivity.this);

                temp = "Paraméter";

                // Átirányít a ResultActivity-re
                Intent Intent = new Intent(v.getContext(), ResultActivity.class);
                v.getContext().startActivity(Intent);

                // Adatot visz át a ResultActivity-re
                Intent intentAdat = new Intent(getBaseContext(), ResultActivity.class);
                intentAdat.putExtra("TEMP", temp);
                startActivity(intentAdat);
            }
        });
    }

    // Időjárás adatok
    private void getWeatherData(String cityName){
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<DataModel> call = apiInterface.getWeatherData(cityName);

        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {

                //tvResultTemp.setText("Hőmérséklet: " + response.body().getMain().getTemp() + " ℃");

            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {

            }
        });
    }

    // "Keresés" gombra kattintva elrejti a billentyűzetet.
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        if(inputMethodManager.isAcceptingText()){
            inputMethodManager.hideSoftInputFromWindow(
                    activity.getCurrentFocus().getWindowToken(),
                    0
            );
        }
    }
}