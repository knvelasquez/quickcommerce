/*package com.quickcommerce.config;

import com.sun.istack.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class which is responsible for handling CORS.
 * Cross-Origin Resource Sharing (CORS) configuration class.
 */
/*@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    /**
     * Responsible for CORS mapping.
     * Overridden from WebMvcConfigurer level.
     * @param theRegistry CorsRegistry
     */
 /*   @Override
    public void addCorsMappings(@NotNull CorsRegistry theRegistry) {
        //End points
        String[] authorizedEndpoints = new String[] {
                "/book/**",
                "/author/**",
                "/authenticate/**"
        };

        //Add mapping
        for (String endPoint : authorizedEndpoints) {
            theRegistry.addMapping(endPoint)
                    .allowedOrigins("http://localhost:5500")
                    .allowedMethods("*") //"HEAD", "GET", "PUT", "POST", "DELETE", "PATCH"
                    .allowedHeaders("*")
                    .allowCredentials(true)
                    .exposedHeaders("Authorization");
        }
    }
}*/