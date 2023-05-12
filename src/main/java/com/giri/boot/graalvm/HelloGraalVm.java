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
            Account.builder().number("A-1").balance(new BigDecimal(100.1239)).build(),
            Account.builder().number("A-2").balance(new BigDecimal(200.989)).build(),
            Account.builder().number("A-3").balance(new BigDecimal(-200.99)).build()
        );
    }
}
