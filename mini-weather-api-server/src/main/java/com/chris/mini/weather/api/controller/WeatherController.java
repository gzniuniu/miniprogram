package com.chris.mini.weather.api.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@ResponseBody
public class WeatherController {
    @Value("${server.port}")
    String port;

    @RequestMapping("/weather")
    public String home(@RequestParam(value = "city", defaultValue = "chris") String city) {
//        https://free-api.heweather.net/s6/weather/now?key=aa5f8fd4d4fc400e9b7858cdebbf7bb1&location=shanghai
        String weatherApiPath = "https://free-api.heweather.net/s6/weather/now?key=aa5f8fd4d4fc400e9b7858cdebbf7bb1&location=shanghai";
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(weatherApiPath)
                    .build();
            Response response = client.newCall(request).execute();
            String responseData = response.body().string();
            JSONObject obj= JSON.parseObject(responseData);
            JSONArray heWeatherJsonArray = obj.getJSONArray("HeWeather6");
            JSONObject obj2= (JSONObject)heWeatherJsonArray.get(0);
            JSONObject object3 = obj2.getJSONObject("now");
            String weatherDes = object3.getString("cond_txt");
            return weatherDes;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Hello world";
//        return "hi " + name + " ,i am from port:" + port;
    }
}
