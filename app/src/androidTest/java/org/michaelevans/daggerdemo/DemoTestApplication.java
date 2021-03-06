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

package org.michaelevans.daggerdemo;

import android.app.Application;

import org.michaelevans.daggerdemo.api.ApiModule;
import org.michaelevans.daggerdemo.api.MockApiModule;
import org.michaelevans.daggerdemo.preferences.PreferencesModule;
import org.michaelevans.daggerdemo.ui.UiModule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by michaelevans on 9/24/14.
 */
public class DemoTestApplication extends DemoApplication {
    public List<Object> getModules() {
        return Arrays.asList(
                new ApplicationModule(this),
                new UiModule(),
                new PreferencesModule(),
                new ApiModule(),
                new MockApiModule()
        );
    }
}
