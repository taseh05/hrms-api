package com.effigo.hrms.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class WebConfig {

    @Bean
    public SecurityFilterChain securityFilterChainOAuth(HttpSecurity security) throws Exception {
        security.csrf(csrf -> csrf.disable());
        security.cors(Customizer.withDefaults());
        return security.build();
    }
}