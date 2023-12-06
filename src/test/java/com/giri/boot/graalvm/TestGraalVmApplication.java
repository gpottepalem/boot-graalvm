package com.giri.boot.graalvm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

/**
 * @author pottepalemg
 * created Dec 06, 2023
 */
@TestConfiguration(proxyBeanMethods = false)
public class TestGraalVmApplication {
    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgresContainer() {
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));
    }

    public static void main(String[] args) {
        SpringApplication.from(GraalVmApplication::main)
            .with(TestGraalVmApplication.class)
            .run(args);
    }
}
