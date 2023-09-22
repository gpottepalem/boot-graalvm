package com.giri.boot.graalvm.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OPEN API configuration
 *
 * @author pottepalemg
 * created Sep 24, 2023
 */
@Configuration
public class OpenApiConfig {
    @Value("${spring.doc.baseURI:http://localhost:8080}")
    String baseURI;

    @Autowired
    BuildProperties buildProperties;

    @Bean
    public OpenAPI customOpenAPI() {
        Components components = new Components();
        SecurityRequirement securityRequirement = new SecurityRequirement();

        return new OpenAPI()
                   .addServersItem(new Server().url(baseURI))
//                   .components(components)
//                   .addSecurityItem(securityRequirement)
                   .info(new Info()
                             .title(buildProperties.get("name"))
                             .description(
                                 "OpenAPI 3 spec for " + buildProperties.get("name") + "<br/><br/>" +
                                     "Version: " + buildProperties.get("version") + "<br/>" +
                                     "Java Version: " + buildProperties.get("java.version") + "<br/>" +
                                     "Spring Boot Version: " + buildProperties.get("spring.boot.version")
                             )
                   );
    }
}
