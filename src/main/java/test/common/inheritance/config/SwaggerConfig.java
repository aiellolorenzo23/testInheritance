package test.common.inheritance.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI opOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Test ereditarietà - REST API")
                        .description("Test eredatarietà Spring Boot application")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Birth Dates Wiki Documentation")
                        .url("https://cryptocasinoblockchain.herokuapp.com/swagger-ui.html"));
    }
}
