package com.chris.eurekaserver.mini.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MiniWeatherEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniWeatherEurekaServerApplication.class, args);
    }

}
