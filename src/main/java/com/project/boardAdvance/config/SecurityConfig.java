package com.project.boardAdvance.config;

import com.project.boardAdvance.model.UserRole;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().cors();
        http.authorizeRequests()
            .antMatchers("/boardPage").hasRole(String.valueOf(UserRole.USER))
            .anyRequest().permitAll()
            .and()
            .formLogin()
            .loginPage("/loginPage").permitAll()
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/boardPage")
            .and()
            .logout()
            .logoutUrl("/bLogout")
            .logoutSuccessUrl("/bHome");



    }

}
