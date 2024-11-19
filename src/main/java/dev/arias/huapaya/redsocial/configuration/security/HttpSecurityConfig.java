package dev.arias.huapaya.redsocial.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;

import dev.arias.huapaya.redsocial.configuration.security.authorization.CustomAuthorizationManager;
import dev.arias.huapaya.redsocial.configuration.security.filter.JwtAuthenticationFilter;
import dev.arias.huapaya.redsocial.configuration.security.handler.CustomAccessDenied;
import lombok.AllArgsConstructor;

@EnableMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@AllArgsConstructor
@Configuration
public class HttpSecurityConfig {

    private final AuthenticationProvider authenticationProvider;

    private final JwtAuthenticationFilter authenticationFilter;

    private final CustomAccessDenied customAccessDenied;

    private final AuthenticationEntryPoint authenticationEntryPoint;

    private final CustomAuthorizationManager customAuthorizationManager;

    private final CorsConfigurationSource corsConfigurationSource;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        SecurityFilterChain filter = http.csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(this.corsConfigurationSource))
                .authenticationProvider(authenticationProvider)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exception -> {
                    exception.accessDeniedHandler(this.customAccessDenied);
                    exception.authenticationEntryPoint(this.authenticationEntryPoint);
                })
                .authorizeHttpRequests(httpRequest -> {
                    httpRequest // Permitir la conexión inicial del WebSocket
                            .requestMatchers("/chat-socket/**").permitAll();
                    // Permitir prefijos de STOMP (aplicación y broker)
                    httpRequest.requestMatchers("/app/**", "/topic/**").permitAll();
                    httpRequest.anyRequest().access(customAuthorizationManager);
                })
                .build();
        return filter;
    }

}
