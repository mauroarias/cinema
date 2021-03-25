package com.example.cinema.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    private final String buildVersion;
    private final String projectName;
    private final String projectDescription;

    public SwaggerConfig(final @Value("${info.app.version}") String buildVersion,
                         final @Value("${info.app.name}") String projectName,
                         final @Value("${info.app.description}") String projectDescription) {
        this.buildVersion = buildVersion;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
    }

    @Bean
    public OpenAPI api() {
        final Info info = new Info().title(projectName).description(projectDescription).version(buildVersion);
        return new OpenAPI().info(info);
    }
}
