package it.nike.gestnike.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * Info Visualizzabile nell'URL http://localhost:[port]/swagger-ui.html
 */

@Configuration
@EnableSwagger2
@SwaggerDefinition(
        info = @Info(
                title = "gestionale nike",
                version = "0.0.1-SNAPSHOT",
                description = "Gestionale per amministrazione "
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"}

)
public class SwaggerConfig
{
    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}