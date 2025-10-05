package org.example.springsecuritydemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails rahul = User.builder()
                .username("rahul")
                .password("{noop}test123")
                .roles("ADMIN")
                .build();

        UserDetails eren = User.builder()
                .username("eren")
                .password("{noop}tatakae")
                .roles("MANAGER")
                .build();

        UserDetails mikasa = User.builder()
                .username("mikasa")
                .password("{noop}ereh")
                .roles("HR")
                .build();

        UserDetails levi = User.builder()
                .username("levi")
                .password("{noop}test")
                .roles("EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(rahul, eren, mikasa);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(csrf -> csrf.disable())


                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/employees/**").hasAnyRole("ADMIN", "MANAGER")
                        .requestMatchers(HttpMethod.GET, "/employees/**").hasAnyRole("ADMIN", "MANAGER", "EMPLOYEE")
                        .anyRequest().permitAll()
                )

                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }
}
