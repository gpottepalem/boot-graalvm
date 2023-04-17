package com.giri.boot.graalvm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
