package com.giri.boot.graalvm;

import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link GraalVmApplication}
 *
 * @author pottepalemg
 * created Nov 18, 2023
 */
public class ApplicationStartsTest {
    /**
     * To cover main method not covered by any tests
     */
    @Test
    void applicationStarts() {
        GraalVmApplication.main(new String[]{});
    }
}
