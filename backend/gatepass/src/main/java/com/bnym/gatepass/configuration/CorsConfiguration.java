package com.bnym.gatepass.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/student/login")
                .allowedOrigins("http://localhost:8090") // Add the allowed origin(s) here
                .allowedMethods("GET", "POST") // Add the allowed HTTP methods here
                .allowedHeaders("*") // Add the allowed headers here
                .allowCredentials(true);
    }
}