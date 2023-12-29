package com.giri.boot.graalvm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraalVmApplication {
    public static void main(String[] args) {
        for (String arg: args) { // let's examine arguments passed
            System.out.println("arg: " + arg);
        }
        SpringApplication.run(GraalVmApplication.class, args);
    }

}
