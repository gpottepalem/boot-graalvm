package com.giri.boot.graalvm;

import com.giri.boot.graalvm.config.TestContainersConfiguration;
import com.giri.boot.graalvm.controller.HelloController;
import com.giri.boot.graalvm.service.AccountService;
import com.giri.boot.graalvm.service.AccountServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.assertj.core.api.Assertions.*;

/**
 * Integration test for {@link GraalVmApplication}
 *
 * @author pottepalemg
 * created Nov 17, 2023
 */
@SpringBootTest
@Import(TestContainersConfiguration.class)
@ActiveProfiles("test")
public class GraalVmApplicationIT {
    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    HelloController helloController;

    @Autowired
    AccountService accountService;

    @Autowired
    PostgreSQLContainer postgreSQLContainer;

    @Test
    void context_loads_and_autowiring_works() {
        assertThat(applicationContext).isNotNull();
        assertThat(helloController).isNotNull();
        assertThat(accountService).isNotNull();

        var accountService = applicationContext.getBean(AccountService.class);
        assertThat(accountService).isInstanceOf(AccountServiceImpl.class);
        assertThat(postgreSQLContainer).isInstanceOf(PostgreSQLContainer.class);
    }

}
