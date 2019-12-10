package com.chris.mini.weather.feign.clients;

import com.chris.mini.weather.feign.clients.fallback.SchedualServiceWeatherHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "mini-weather-api-server",fallback = SchedualServiceWeatherHystric.class)
public interface SchedualServiceWeather {
    @RequestMapping(value = "/weather",method = RequestMethod.GET)
    Object getWeatherFromClientOne(@RequestParam(value = "city") String city);

}
