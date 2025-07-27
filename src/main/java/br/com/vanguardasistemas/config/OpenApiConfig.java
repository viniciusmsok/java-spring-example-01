package br.com.vanguardasistemas.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Payment Slip API",
        description = "Documentação dos endpoints da API do sistema Payment Slip da Vanguarda Sistemas.",
        version = "1.0"
    )
)
public class OpenApiConfig {
} 