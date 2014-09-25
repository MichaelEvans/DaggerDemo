/*
 * Copyright 2014 Michael Evans
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.michaelevans.daggerdemo.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.util.Log;

import org.michaelevans.daggerdemo.DemoApplication;
import org.michaelevans.daggerdemo.R;
import org.michaelevans.daggerdemo.preferences.WeatherPreferences;

import java.util.Arrays;

import javax.inject.Inject;

/**
 * Created by michael on 9/24/14.
 */
public class SettingsActivity extends PreferenceActivity implements
        SharedPreferences.OnSharedPreferenceChangeListener {

    private final String PREFERENCE_KEY = "pref_unit";

    @Inject
    WeatherPreferences weatherPreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((DemoApplication) getApplication()).inject(this);

        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListPreference preference = (ListPreference) findPreference(PREFERENCE_KEY);
        preference.setValueIndex(weatherPreferences.getPreferredUnit().ordinal());
        preference.setSummary(preference.getEntry());
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        ListPreference preference = (ListPreference) findPreference(key);
        int index = Arrays.asList(preference.getEntryValues()).indexOf(preference.getValue());
        weatherPreferences.setPreferredUnit(WeatherPreferences.Unit.values()[index]);
        preference.setSummary(preference.getEntry());
    }
}
