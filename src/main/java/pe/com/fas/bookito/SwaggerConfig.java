package pe.com.fas.bookito;

import org.hibernate.validator.constraintvalidators.RegexpURLValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket projectApi() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("pe.com.fas.bookito.restcontroller"))
			.build()
			.apiInfo(metaData());
	}
	
	public ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "BOOKITO REST API",
                "REST API for Bookito Application",
                "1.0",
                "Terms of service",
                new Contact("The Bookito Team", "https://springframework.guru/about/", "emgore_1410@hotmail.com"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
}
