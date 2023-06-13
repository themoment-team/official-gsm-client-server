package com.example.officialgsmclientserver.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "Official-GSM Client",
                description = "Official-GSM Client API명세",
                version = "1.0.0"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi chatOpenApi() {
        String paths = "/api/**";

        return GroupedOpenApi.builder()
                .group("Official-GSM Client API 1.0.0")
                .pathsToMatch(paths)
                .build();
    }
}