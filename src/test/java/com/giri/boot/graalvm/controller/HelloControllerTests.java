package com.giri.boot.graalvm.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Unit test for {@link HelloController}
 *
 * @author pottepalemg
 * created Nov 17, 2023
 */
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void greeting_end_point() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void accounts_end_point() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/accounts"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
