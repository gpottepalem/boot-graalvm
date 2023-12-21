package com.giri.boot.graalvm.controller;

import com.giri.boot.graalvm.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pottepalemg
 * created Apr 12, 2023
 */
@RestController
@Slf4j
public class HelloController {
    @Value("${app.greeting.message:in Default}")
    private String message;

    @Autowired
    Environment environment;

    @GetMapping("/")
    public String greet() {
        log.info("Request for greet...");
        return "Welcome to %s %s! Active Profiles: %s".formatted(
            environment.getProperty("spring.application.name"),
            message,
            (environment.getActiveProfiles().length > 0) ?
                Arrays.stream(environment.getActiveProfiles()).collect(Collectors.joining(",")) :
                Arrays.stream(environment.getDefaultProfiles()).collect(Collectors.joining(","))
        );
    }

    @GetMapping("/accounts")
    public List<Account> accounts() {
        log.info("Request for accounts...");
        return List.of(
            Account.builder().number("A-1").balance(new BigDecimal(100.1239)).build(),
            Account.builder().number("A-2").balance(new BigDecimal(200.989)).build(),
            Account.builder().number("A-3").balance(new BigDecimal(-200.99)).build()
        );
    }
}
