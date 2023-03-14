package com.example.githuboauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
public class SecurityConfig {

    //config HTTP security
    //securityFilterChain을 반환하고 Bean으로 등록함으로써 컴포넌트 기반의 보안 설정
    @Bean
    public  SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .exceptionHandling(e -> e.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                .oauth2Login();


        return http.build();
    }

}
