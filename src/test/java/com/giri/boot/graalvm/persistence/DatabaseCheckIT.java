package com.giri.boot.graalvm.persistence;

import com.giri.boot.graalvm.config.TestContainersConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;

/**
 * An integration test to check Database connectivity.
 *
 * @author Giri Pottepalem
 */
@ActiveProfiles("test")
// We don't want the H2 in-memory database.
// We will provide a custom 'test container' as DataSource, so don't replace it.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@Import(TestContainersConfiguration.class)
public class DatabaseCheckIT {
    @Autowired
    JdbcClient jdbcClient;

    @Test
    void database_connection_works_and_version_looks_good() {
        assertThat(jdbcClient.sql("SELECT version()").query(String.class).single())
            .contains("16.0");
    }
}
