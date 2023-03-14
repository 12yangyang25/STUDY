package com.example.githuboauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@SpringBootApplication
@RestController
public class GithubOauthApplication {

//	 Spring Security OAuth 2.0 Client starter을 종속성으로 추가 => spring security에서 인증 없는 요청을 자동으로 로그인 창으로 넘김
//	 localhost:8080/login으로 이동
//	 이 때, properties에 설정된 값이 없으면 내부 default 로그인 창 띄우고, 있으면

	@GetMapping("/user")
	public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal){
		System.out.println(principal.getAttributes().toString());
		return Collections.singletonMap("name", principal.getAttribute("name"));
	}
	public static void main(String[] args) {
		SpringApplication.run(GithubOauthApplication.class, args);
	}

}
