package com.giri.boot.graalvm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.simple.JdbcClient;

@SpringBootApplication
@Slf4j
public class GraalVmApplication {
    public static void main(String[] args) {
        for (String arg: args) { // let's examine arguments passed
            System.out.println("arg: " + arg);
        }
        SpringApplication.run(GraalVmApplication.class, args);
    }

    @Autowired(required = false)
    JdbcClient jdbcClient;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            if (jdbcClient != null) {
                log.info("Database check: {}", jdbcClient.sql("SELECT version()").query(String.class).single());
            }
        };
    }
}
