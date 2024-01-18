package com.giri.boot.graalvm.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

/**
 * Test Configuration for testcontainers.
 *
 * @author pottepalemg
 * created Dec 06, 2023
 */
@TestConfiguration(proxyBeanMethods = false)
@Slf4j
public class TestContainersConfiguration {
    // https://codereviewvideos.com/postgres-16-docker-workaround-program-postgres-is-needed-by-initdb/
    private static final String POSTGRES_IMAGE_TAG = "postgres:16.0"; // Issue: postgres:latest or postgres:16, 16-alpine

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgreSQLContainer() {
        log.info("PostgreSQLContainer bean...");

        return new PostgreSQLContainer<>(POSTGRES_IMAGE_TAG)
                   .withDatabaseName("boot-graalvm")
                   .withUsername("postgres")
                   .withPassword("s3cr3t")
                   .withReuse(true);
    }
}
