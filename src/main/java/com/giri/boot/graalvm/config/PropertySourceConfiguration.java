package com.giri.boot.graalvm.config;

/**
 * Registers various property source files.
 * @see https://www.baeldung.com/properties-with-spring
 *
 * @author pottepalemg
 * created Oct 27, 2023
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
@Configuration
@PropertySource("classpath:git.properties")
public class PropertySourceConfiguration {

}
