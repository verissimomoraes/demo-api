package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.servlet.http.HttpServletRequest;
import io.swagger.v3.oas.annotations.Operation;


@Configuration
public class OpenApiConfig {
    /**
     * Define as informa es de identifica o da API para a documenta o do OpenAPI.
     *
     * @return Uma inst ncia de OpenAPI com as informa es de identifica o da API.
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Item API")
                .version("1.0")
                .description("API REST para gerenciamento de itens"));
    }
}
