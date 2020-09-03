package com.kirito.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class KiritoGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.kirito.cloud.KiritoGatewayApplication.class, args);
    }

}
