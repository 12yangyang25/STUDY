package com.example.oauthlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.Map;

@SpringBootApplication
public class OauthLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthLoginApplication.class, args);
	}

}
