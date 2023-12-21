package com.giri.boot.graalvm;

import com.giri.boot.graalvm.config.TestContainersConfiguration;
import com.giri.boot.graalvm.service.AccountService;
import com.giri.boot.graalvm.service.AccountServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;

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
    PostgreSQLContainer postgreSQLContainer;

    @Test
    void context_loads() {
        var accountService = applicationContext.getBean(AccountService.class);
        Assertions.assertThat(accountService).isInstanceOf(AccountServiceImpl.class);
        Assertions.assertThat(postgreSQLContainer).isInstanceOf(PostgreSQLContainer.class);
    }

}
