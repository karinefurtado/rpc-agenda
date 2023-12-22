package com.uern.rpcdistribuidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    
    @Bean
    public RemoteInterface remoteService() {
        try {
            return new RemoteImplementation();
        } catch (Exception e) {
            throw new RuntimeException("Error creating RemoteImplementation bean", e);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
