/*
 * Copyright 2014 Michael Evans
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.michaelevans.daggerdemo.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.michaelevans.daggerdemo.DemoApplication;
import org.michaelevans.daggerdemo.R;
import org.michaelevans.daggerdemo.annotations.WundergroundApiKey;
import org.michaelevans.daggerdemo.api.WundergroundService;
import org.michaelevans.daggerdemo.model.WeatherData;
import org.michaelevans.daggerdemo.preferences.WeatherPreferences;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends Activity {
    @Inject @WundergroundApiKey String apiKey;
    @Inject WundergroundService service;
    @Inject WeatherPreferences weatherPreferences;

    @InjectView(R.id.current_temperature)
    TextView currentTemperature;

    @InjectView(R.id.city_picker)
    Spinner currentCity;

    private String[] mCities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((DemoApplication) getApplication()).inject(this);

        ButterKnife.inject(this);

        mCities = getResources().getStringArray(R.array.city_names);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, mCities);
        currentCity.setAdapter(dataAdapter);
        currentCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0)
                    fetchData(mCities[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void fetchData(String cityName) {
        service.getWeatherData(apiKey, cityName, new Callback<WeatherData>() {
            @Override
            public void success(WeatherData weatherData, Response response) {
                if(weatherPreferences.getPreferredUnit().equals(WeatherPreferences.Unit.FAHRENHEIT))
                    currentTemperature.setText(String.valueOf(weatherData.getCurrentObservation().getTempF()));
                else
                    currentTemperature.setText(String.valueOf(weatherData.getCurrentObservation().getTempC()));
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
