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

package org.michaelevans.daggerdemo.api;

import org.michaelevans.daggerdemo.model.WeatherData;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by michael on 9/23/14.
 */
public interface WundergroundService {
    @GET("/api/{apiKey}/conditions/q/CA/{cityName}.json")
    public void getWeatherData(@Path("apiKey") String apiKey, @Path("cityName") String cityName, Callback<WeatherData> callback);

}
