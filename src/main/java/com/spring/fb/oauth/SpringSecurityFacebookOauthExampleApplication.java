package com.spring.fb.oauth;

import java.security.Principal;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class SpringSecurityFacebookOauthExampleApplication {

	@GetMapping("/")
	public String fbLogin(Principal principal) {
		Map<String,Object> details = (Map<String, Object>) ((OAuth2Authentication)principal).getUserAuthentication().getDetails();
		String username = details.get("name").toString();
		return "Hello "+username;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityFacebookOauthExampleApplication.class, args);
	}

}
