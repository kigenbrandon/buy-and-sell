package com.codeWithXForward.buyandsell.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//@EnableMethodSecurity
public class ApplicationConfig {
//    private final LogoutHandler logoutHandler;
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http)  throws Exception{
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(req->
//                        req
//                                .requestMatchers("api/v1/product")
//                                .permitAll()
//                                .requestMatchers(HttpMethod.GET,"api/v1/customer/all").fullyAuthenticated()
//                        )
//                .sessionManagement(session->
//                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                )
//                .logout(logout ->
//                        logout.logoutUrl("api/v1/logout")
//                );
//
//        return http.build();
//    }
}
