package com.kirito.cloud.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.kirito.cloud")
public class KiritoAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(KiritoAuthApplication.class, args);
    }

}
