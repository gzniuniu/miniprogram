package com.chris.mini.weather.feign.clients.fallback;

import com.chris.mini.weather.feign.clients.SchedualServiceWeather;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class SchedualServiceWeatherHystric implements SchedualServiceWeather {
    @Override
    public Object getWeatherFromClientOne(String city){
        return "sorry,this is feign hystric, you are fail,"+city;
    }
}
