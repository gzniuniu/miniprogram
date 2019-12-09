package com.chris.mini.weather.feign.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "mini-weather-service-weather")
public interface SchedualServiceWeather {
    @RequestMapping(value = "/weather",method = RequestMethod.GET)
    String getWeatherFromClientOne(@RequestParam(value = "city") String city);

}
