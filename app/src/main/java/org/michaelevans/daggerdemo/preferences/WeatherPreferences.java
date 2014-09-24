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

package org.michaelevans.daggerdemo.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by michael on 9/23/14.
 */
public class WeatherPreferences {
    private final String FILE_NAME = "user_preferences";

    private final String KEY_UNIT = "unit";

    public enum Unit { FAHRENHEIT, CELCIUS }

    SharedPreferences preferences;

    public WeatherPreferences(Context context) {
        this.preferences = context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE);
    }

    public Unit getPreferredUnit(){
        return Unit.values()[preferences.getInt(KEY_UNIT, Unit.FAHRENHEIT.ordinal())];
    }

    public void setPreferredUnit(Unit unit){
        preferences.edit().putInt(KEY_UNIT, unit.ordinal()).commit();
    }

    public void clearPreferences(){
        preferences.edit().clear().apply();
    }
}
