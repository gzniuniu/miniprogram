package com.chris.mini.weather.api.bean;

public class Weather {
    public String city;
    public String mini_date;
    public String now_weather;
    public String temperature;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMini_date() {
        return mini_date;
    }

    public void setMini_date(String mini_date) {
        this.mini_date = mini_date;
    }

    public String getNow_weather() {
        return now_weather;
    }

    public void setNow_weather(String now_weather) {
        this.now_weather = now_weather;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
