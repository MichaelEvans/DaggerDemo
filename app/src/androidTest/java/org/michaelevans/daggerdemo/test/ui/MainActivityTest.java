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

package org.michaelevans.daggerdemo.test.ui;

import android.test.ActivityInstrumentationTestCase2;

import com.squareup.spoon.Spoon;

import org.michaelevans.daggerdemo.DemoApplication;
import org.michaelevans.daggerdemo.R;
import org.michaelevans.daggerdemo.api.MockApiModule;
import org.michaelevans.daggerdemo.ui.MainActivity;

import java.util.ArrayList;

import dagger.ObjectGraph;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onData;
import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.isDisplayed;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        getActivity();
    }

    public void testUiLoads() throws Exception {
        onView(withId(R.id.city_picker))      // withId(R.id.my_view) is a ViewMatcher
            .check(matches(isDisplayed())); // matches(isDisplayed()) is a ViewAssertion
    }

    public void testChangeCityToYosemite() throws Exception{
        onView(withId(R.id.city_picker)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Yosemite")))
                .perform(click());
        onView(withId(R.id.current_temperature))
                .check(matches(withText(containsString("55.5"))));
        Spoon.screenshot(getActivity(), "picked_city");
    }

    public void testChangeCityToSacramento() throws Exception{
        onView(withId(R.id.city_picker)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Sacramento")))
                .perform(click());
        Spoon.screenshot(getActivity(), "picked_city");
        onView(withId(R.id.current_temperature))
                .check(matches(withText(containsString("73.5"))));
    }
}
