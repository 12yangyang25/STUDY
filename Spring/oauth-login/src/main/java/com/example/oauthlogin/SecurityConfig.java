package com.example.oauthlogin;

import ch.qos.logback.classic.selector.servlet.LoggerContextFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests().requestMatchers( "/").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .successHandler((req, res, authentication) -> {
                    res.sendRedirect("/profile");
                });

        return http.build();
    }
}
