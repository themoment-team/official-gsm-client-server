package com.example.officialgsmclientserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class OfficialGsmClientServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfficialGsmClientServerApplication.class, args);
    }

}
