package com.gustavodiniz.swplanetapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SwPlanetApiApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SwPlanetApiApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("[sw planet api] - started successfully.");
    }
}
