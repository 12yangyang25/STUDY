package com.example.oauthlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;

@Controller
public class GithubController {
    @Autowired
    OAuth2AuthorizedClientService clientService;

    @GetMapping("/profile")
    public String profile(Authentication authentication, Model model){
        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
        OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(oauthToken.getAuthorizedClientRegistrationId(), oauthToken.getName());

        String token = client.getAccessToken().getTokenValue();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + token);
        httpHeaders.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        RequestEntity<Void> request = new RequestEntity<>(httpHeaders, HttpMethod.GET, URI.create("https://api.github.com/user/emails"));
//
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(request, String.class);


        model.addAttribute("name", oauthToken.getPrincipal().getAttribute("name"));

        System.out.println(response.getBody());

        return "/users/profile";
    }
}
