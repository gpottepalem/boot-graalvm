package com.giri.boot.graalvm.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * Spock specification for {@link HelloController}
 *
 * @author pottepalemg
 * created Nov 18, 2023
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles('test')
class HelloControllerIS extends Specification {
    @Autowired
    MockMvc mockMvc

    def "get request to greeting end point returns expected content '' and status 200"() {
        expect: "status 200 and response content ''"
        mockMvc.perform(get('/'))
                .andExpect(status().isOk())
                .andReturn()
                .response
                .contentAsString == 'Welcome to boot-graalvm in Default! Active Profiles: test'
    }

    def "get request to accounts end point returns expected content '' and status 200"() {
        expect: "status 200 and response content ''"
        mockMvc.perform(get('/accounts'))
                .andExpect(status().isOk())
                .andReturn()
                .response
                .contentAsString == '[{"number":"A-1","balance":100.12},{"number":"A-2","balance":200.99},{"number":"A-3","balance":"Negative"}]'
    }
}
