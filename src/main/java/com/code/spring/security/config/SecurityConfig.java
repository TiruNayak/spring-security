package com.code.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//  	http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated()); //secures all the apis     	
//   	http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll()); //allows all the apis without security   	
//    	http.authorizeHttpRequests((requests) -> requests.anyRequest().denyAll()); //denies all the apis - gives 403 error(forbidden error)
    	
    	http.authorizeHttpRequests((requests) ->  requests
    			.requestMatchers("/account","/balance","/loans","/cards","/account").authenticated()  //secures set of request matched apis
    			.requestMatchers("/welcome","/contact","/notices","/error").permitAll()); //allows of request matched apis without security
       
//    	http.formLogin(flc->flc.disable());  //disables form login authentication
//      http.httpBasic(hbc->hbc.disable());  //disables http basic authentication

    	http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
       
		return http.build();
    }
	
	

}
