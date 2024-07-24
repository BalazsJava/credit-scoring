package com.app.creditscoring.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/**
 * Available at <a href="http://localhost:8080/swagger-ui.html">http://localhost:8080/swagger-ui.html</a>
 */
@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Credit Scoring App",
                description = "Processing and analyzing customer data")
)
public class OpenAPIConfig {
}