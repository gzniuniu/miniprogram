package com.chris.mini.weather.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.chris.mini.weather.api.serivce.impl.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@Controller
@ResponseBody
public class WeatherController {
    @Value("${server.port}")
    String port;
    @Autowired
    WeatherServiceImpl weatherServiceImpl;

    @RequestMapping("/weather")
    public Object home(@RequestParam(value = "city", defaultValue = "shanghai") String city) {
//        https://free-api.heweather.net/s6/weather/now?key=aa5f8fd4d4fc400e9b7858cdebbf7bb1&location=shanghai
        Object weather = weatherServiceImpl.getTodayWeather(city);
        if (Objects.nonNull(weather)){
            return (JSONObject)weather;
        }
        return "Hello world from weather controller";
//        return "hi " + name + " ,i am from port:" + port;
    }
}
