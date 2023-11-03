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
import org.springframework.core.env.Environment;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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
    Environment env;

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
                                 STR."""
                                     <pre>
                                     OpenAPI 3 spec for  : \{buildProperties.get("name")}
                                     App Version         : \{buildProperties.get("version")}
                                     Java Version        : \{buildProperties.get("java.version")}
                                     Spring Boot Version : \{buildProperties.get("spring.boot.version")}
                                     Git Branch          : \{env.getProperty("git.branch")}
                                         Commit Id       : \{env.getProperty("git.commit.id.full")}
                                         Message         : \{env.getProperty("git.commit.message.full")}
                                         Built at        : \{
                                            ZonedDateTime.parse(
                                                env.getProperty("git.build.time"), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ")
                                            ).format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM))
                                         }
                                         Build User      : \{env.getProperty("git.build.user.name")}
                                     </pre>
                                     """
                             )
                   );
    }
}
