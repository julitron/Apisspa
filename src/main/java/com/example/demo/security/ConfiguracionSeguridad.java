package com.example.demo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class ConfiguracionSeguridad {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .cors()
        .and()
        .csrf().disable()
        .authorizeRequests()
        .antMatchers(HttpMethod.POST,                "/producto").permitAll()
        .antMatchers(HttpMethod.GET,               "/producto").permitAll()
        .antMatchers(HttpMethod.GET,               "/producto/{id}").permitAll()
        .antMatchers(HttpMethod.DELETE,               "/producto/{id}").permitAll()
        .antMatchers(HttpMethod.PUT,               "/producto/{id}").permitAll()
        .anyRequest().authenticated()
        .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }
    /**
     * @return
     */
    
    
}
