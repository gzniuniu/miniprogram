package com.chris.mini.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MiniWeatherApiServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniWeatherApiServerApplication.class, args);
    }

}
