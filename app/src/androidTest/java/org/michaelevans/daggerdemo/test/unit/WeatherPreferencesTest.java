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

package org.michaelevans.daggerdemo.test.unit;

import android.test.InstrumentationTestCase;

import org.michaelevans.daggerdemo.preferences.WeatherPreferences;
import static org.michaelevans.daggerdemo.preferences.WeatherPreferences.Unit;

/**
 * Created by michael on 9/23/14.
 */
public class WeatherPreferencesTest extends InstrumentationTestCase{
    private WeatherPreferences preferences;

    @Override
    public void setUp() throws Exception {
        preferences = new WeatherPreferences(getInstrumentation().getContext());
        preferences.clearPreferences();
    }

    public void testGetUnitFarenheit() throws Exception {
        preferences.setPreferredUnit(Unit.FAHRENHEIT);
        assertEquals(Unit.FAHRENHEIT, preferences.getPreferredUnit());
    }

    public void testGetUnitCelcius() throws Exception {
        preferences.setPreferredUnit(Unit.CELCIUS);
        assertEquals(Unit.CELCIUS, preferences.getPreferredUnit());
    }

    public void testDefaultUnit() throws Exception {
        assertEquals(Unit.FAHRENHEIT, preferences.getPreferredUnit());
    }
}
