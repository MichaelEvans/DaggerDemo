##About

This is just a sample toy app that demonstrates how you can use [Dagger](http://square.github.io/dagger/) to write an Android application in a way that is modular and easily testable. 

It demonstrates how you can use unit tests (without Robolectric, hopefully Android Studio gets proper Robolectric support soon), as well as [Espresso](https://code.google.com/p/android-test-kit/) to write UI tests. 

There are modules written for application preferences and an API client (using [Retrofit](http://square.github.io/retrofit/) to talk to Wunderground's forecast API). It also demonstrates how you can override a module only for tests, so that you can stub the response from the API for writing reliable tests. 

###Running the sample

If you want to run this sample, you'll need an [API key from Wunderground](http://www.wunderground.com/weather/api/) and can add it as a string resource.

##License

```
Copyright 2014 Michael Evans

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
