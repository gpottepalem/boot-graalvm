package com.giri.boot.graalvm;

import com.giri.boot.graalvm.controller.HelloController;
import com.giri.boot.graalvm.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.*;

/**
 * Unit test for {@link GraalVmApplication} context
 */
@SpringBootTest
class GraalVmApplicationTest {
    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    HelloController helloController;

    @Autowired
    AccountService accountService;

    @Test
    void context_loads_and_autowiring_works() {
        assertThat(applicationContext).isNotNull();
        assertThat(helloController).isNotNull();
        assertThat(accountService).isNotNull();
    }

}
