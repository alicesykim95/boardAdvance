package com.project.boardAdvance.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().cors();
        http.authorizeRequests()
            .antMatchers("/boardPage").access("hasRole('USER')")
            .anyRequest().permitAll()
        .and()
            .formLogin()
            .loginPage("/loginPage").permitAll()
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/joinPage").and().httpBasic();

    }

}
