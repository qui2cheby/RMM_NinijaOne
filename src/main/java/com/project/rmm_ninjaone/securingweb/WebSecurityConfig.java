package com.project.rmm_ninjaone.securingweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 *  Class is annotated with @EnableWebSecurity to enable Spring Security’s
 *  web security support and provide the Spring MVC integration.
 *  It also exposes two beans to set some specifics for the web security configuration
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    /**
     * Defines which URL paths should be secured and which should not
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .antMatchers("/",
                                "/home",
                                "/h2/**",
                                "test.do",
                                "/ledger/**",
                                "/service/**",
                                "/device/**"
                                ).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());
        http.csrf().disable(); /*Disable CSRF protection*/
        http.headers().frameOptions().disable();/*Disable X-Frame-Options in Spring Security */
        return http.build();
    }

    /**
     * Sets up an in-memory user store with a single user
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}
