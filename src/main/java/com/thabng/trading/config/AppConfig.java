package com.thabng.trading.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class AppConfig {

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.sessionManagement(management ->management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize //Dealing with
                        .requestMatchers("/api/**").authenticated() // Secure this endpoints that starts with /api
                        .requestMatchers("/").permitAll())  // Allow all endpoint for public access
                    .addFilterBefore(new JwTokenValidator(), BasicAuthenticationFilter.class)//Session validator to check if endpoind is validated or not
                    .csrf(csrf->csrf.disable())
                    .cors(cors->cors.configurationSource(corsConfigurationSource()))

                .logout(logout -> logout.permitAll());                 // Optional: allow logout for all

        return http.build();
    }
//Cors to avoid error when we connect with front end
    private CorsConfigurationSource corsConfigurationSource() {
        return null;
    }

}
