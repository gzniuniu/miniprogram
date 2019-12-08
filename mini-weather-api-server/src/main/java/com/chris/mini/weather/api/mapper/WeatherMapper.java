package com.chris.mini.weather.api.mapper;

import com.chris.mini.weather.api.bean.Weather;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WeatherMapper {
    public Weather find(@Param("city")String city);
    public boolean insert(@Param("city")String city,@Param("mini_date")String mini_date
            ,@Param("now_weather")String now_weather,@Param("temperature")String temperature);
}
