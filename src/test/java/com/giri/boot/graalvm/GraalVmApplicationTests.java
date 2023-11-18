package com.giri.boot.graalvm;

import com.giri.boot.graalvm.controller.HelloController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GraalVmApplicationTests {
    @Autowired
    HelloController helloController;

    @Test
    void contextLoads() {
        Assertions.assertThat(helloController).isNotNull();
    }

}
