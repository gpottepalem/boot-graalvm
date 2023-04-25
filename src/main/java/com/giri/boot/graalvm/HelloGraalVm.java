package com.giri.boot.graalvm;

import com.giri.boot.graalvm.domain.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author pottepalemg
 * created Apr 12, 2023
 */
@RestController
public class HelloGraalVm {
    @GetMapping("/")
    public String greet() {
        return "Hello GraalVM\n";
    }

    @GetMapping("/accounts")
    public List<Account> accounts() {
        return List.of(
            new Account("A-1", new BigDecimal(100)),
            new Account("A-2", new BigDecimal(200.99)),
            new Account("A-3", new BigDecimal(-200.99))
        );
    }
}
