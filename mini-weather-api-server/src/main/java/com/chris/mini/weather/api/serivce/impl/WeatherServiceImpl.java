package com.chris.mini.weather.api.serivce.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chris.mini.weather.api.bean.Weather;
import com.chris.mini.weather.api.mapper.WeatherMapper;
import com.chris.mini.weather.api.serivce.WeatherService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

//@ComponentScan({"com.chris.mini.weather.api.mapper"})
@Service
public class WeatherServiceImpl implements WeatherService {
    @Resource
    private WeatherMapper weatherMapper;

    public Object getTodayWeather(String city){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String mini_date = format.format(date);
        Weather weather = weatherMapper.find(city);
        if (Objects.nonNull(weather)) {

            JSONObject dbJson = new JSONObject();
            dbJson.put("city", city);
            dbJson.put("today", mini_date);
            dbJson.put("nowWeather", weather.getNow_weather());
            dbJson.put("temperature", weather.getTemperature());
            return dbJson;
        }else {
            StringBuilder weatherApiPath = new StringBuilder();
            weatherApiPath.append("https://free-api.heweather.net/s6/weather/now?key=aa5f8fd4d4fc400e9b7858cdebbf7bb1&location=");
            if (StringUtils.isNotBlank(city)) {
                String weatherCity = city;
                weatherApiPath.append(weatherCity);
            }
            try {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(weatherApiPath.toString())
                        .build();
                Response response = client.newCall(request).execute();
                String responseData = response.body().string();
                JSONObject obj = JSON.parseObject(responseData);
                JSONArray heWeatherJsonArray = obj.getJSONArray("HeWeather6");
                JSONObject obj2 = (JSONObject) heWeatherJsonArray.get(0);
                JSONObject nowData = (JSONObject) obj2.get("now");
                String temperature = nowData.getString("tmp");
                String nowWeather = nowData.getString("cond_txt");
//                Date date = new Date();
//                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//                String today = format.format(date);
                weatherMapper.insert(city,mini_date,nowWeather,temperature);
                JSONObject returnJson = new JSONObject();
                returnJson.put("city", city);
                returnJson.put("today", mini_date);
                returnJson.put("nowWeather", nowWeather);
                returnJson.put("temperature", temperature);
                return returnJson;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
