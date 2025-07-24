package br.com.vanguardasistemas.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Vanguarda Sistemas API",
        description = "Documentação dos endpoints da API do projeto Vanguarda Sistemas.",
        version = "1.0"
    )
)
public class OpenApiConfig {
} 