package com.example.anotherspringsecurity.configuration;

import com.example.anotherspringsecurity.model.SSUserDetailsService;
import com.example.anotherspringsecurity.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AppUserRepository userRepository;

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new SSUserDetailsService(userRepository);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceBean()).passwordEncoder(new BCryptPasswordEncoder());
    }
}
