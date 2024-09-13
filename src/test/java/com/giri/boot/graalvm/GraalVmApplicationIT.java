package com.giri.boot.graalvm;

import com.giri.boot.graalvm.config.TestContainersConfiguration;
import com.giri.boot.graalvm.controller.HelloController;
import com.giri.boot.graalvm.service.AccountService;
import com.giri.boot.graalvm.service.AccountServiceImpl;
import org.junit.jupiter.api.DisplayName;
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    useMainMethod = SpringBootTest.UseMainMethod.ALWAYS // Get the main method coverage by this from this smoke test
)
@Import(TestContainersConfiguration.class)
@ActiveProfiles("test")
class GraalVmApplicationIT {
    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    HelloController helloController;

    @Autowired
    AccountService accountService;

    @Autowired
    PostgreSQLContainer postgreSQLContainer;

    @Test
    @DisplayName("An integration Smoke Test to ensure that the application contetx loads and autowiring works.")
    void smokeTest_context_loads_and_autowiring_works() {
        assertThat(applicationContext).isNotNull();
        assertThat(helloController).isNotNull();
        assertThat(accountService).isNotNull();

        var service = applicationContext.getBean(AccountService.class);
        assertThat(service).isInstanceOf(AccountServiceImpl.class);
        assertThat(postgreSQLContainer).isInstanceOf(PostgreSQLContainer.class);
    }

}
