package com.work.petclinic.messages.api.docs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import com.wordnik.swagger.model.ApiInfo;


@Configuration
@EnableSwagger
@ComponentScan("com.work.petclinic.messages.api.rest")
public class SwaggerConfig {

    public static final String DEFAULT_INCLUDE_PATTERNS = "/rest/.*";

    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean 
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(apiInfo())
                .includePatterns(DEFAULT_INCLUDE_PATTERNS);
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot Sample REST APIs",
                "The APIs here demonstrate creating a 'production-ready' service built with Spring Boot and other helpful libraries",
                "http://opensource.org/licenses/MIT",
                "khoubyari@gmail.com",
                "MIT",
                "http://opensource.org/licenses/MIT"
        );
        return apiInfo;
    }
}
