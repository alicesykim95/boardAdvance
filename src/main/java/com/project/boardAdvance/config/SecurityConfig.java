package com.project.boardAdvance.config;

import com.project.boardAdvance.config.auth.PrincipalOauth2UserService;
import com.project.boardAdvance.model.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PrincipalOauth2UserService principalOauth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().headers().frameOptions().disable();
        http.authorizeRequests()
            .antMatchers("/boardPage").access("hasRole('ROLE_USER')")
            .antMatchers("/boardList").access("hasRole('ROLE_USER')")
            .anyRequest().permitAll()
            .and()
                .formLogin()
                .loginPage("/loginPage").permitAll()
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/boardPage")
            .and()
                .logout()
                .logoutUrl("/bLogout")
                .logoutSuccessUrl("/bHome")
            .and()
                .oauth2Login()
                .userInfoEndpoint()// 로그인 성공 후 사용자 정보를 가져올때 설정을 담당
                .userService (principalOauth2UserService) // 성공 후 후속 조치를 해당 서비스단으로 넘김
            ;

    }

}
