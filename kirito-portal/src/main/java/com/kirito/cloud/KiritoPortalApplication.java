package com.kirito.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class KiritoPortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(KiritoPortalApplication.class,args);
    }
}
