package com.example.oauthlogin;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;

public class SpringConfig {
    @Bean
    public OAuth2AuthorizedClientService clientService(){
        return new OAuth2AuthorizedClientService() {
            @Override
            public <T extends OAuth2AuthorizedClient> T loadAuthorizedClient(String clientRegistrationId, String principalName) {
                return null;
            }

            @Override
            public void saveAuthorizedClient(OAuth2AuthorizedClient authorizedClient, Authentication principal) {

            }

            @Override
            public void removeAuthorizedClient(String clientRegistrationId, String principalName) {

            }
        };
    }
}
