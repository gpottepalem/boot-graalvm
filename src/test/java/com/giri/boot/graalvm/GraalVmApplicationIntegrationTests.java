package com.giri.boot.graalvm;

import com.giri.boot.graalvm.service.AccountService;
import com.giri.boot.graalvm.service.AccountServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Integration test for {@link GraalVmApplication}
 *
 * @author pottepalemg
 * created Nov 17, 2023
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class GraalVmApplicationIntegrationTests {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    void context_loads() {
        var application = applicationContext.getBean(AccountService.class);
        Assertions.assertThat(application).isInstanceOf(AccountServiceImpl.class);
    }

}
