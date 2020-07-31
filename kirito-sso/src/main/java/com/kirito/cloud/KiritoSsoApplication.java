package com.kirito.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class KiritoSsoApplication {
    public static void main(String[] args) {
        SpringApplication.run(KiritoSsoApplication.class,args);
    }
}
