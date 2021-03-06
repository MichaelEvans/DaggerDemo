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

package org.michaelevans.daggerdemo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by michael on 9/23/14.
 */
public class CurrentObservation {
    @SerializedName("temp_f")
    private double tempF;
    @SerializedName("temp_c")
    private double tempC;

    public CurrentObservation(double tempF, double tempC) {
        this.tempF = tempF;
        this.tempC = tempC;
    }

    public double getTempF() {
        return tempF;
    }

    public double getTempC() {
        return tempC;
    }
}
