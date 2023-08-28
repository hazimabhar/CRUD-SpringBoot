package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // URL patterns to allow CORS for
            .allowedOrigins("http://localhost:5173") // Allowed origin(s)
            .allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed HTTP methods
            .allowedHeaders("Authorization", "Content-Type") // Allowed headers
            .exposedHeaders("Custom-Header") // Headers exposed to the response
            .allowCredentials(true); // Allow including credentials like cookies
    }
}
