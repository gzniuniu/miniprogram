package com.chris.mini.weather.feign.web;

import com.chris.mini.weather.feign.clients.SchedualServiceWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    SchedualServiceWeather schedualServiceWeather;

    @GetMapping(value = "/weather")
    public String sayHi(@RequestParam String city) {
        return schedualServiceWeather.getWeatherFromClientOne( city );
    }
}
