package com.soomgorepeat.repeat.configuration.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
                .cors().and()
                .authorizeRequests().antMatchers("/auth/signin", "/test/**")
                .permitAll()
                .anyRequest().
                authenticated()
                .and().formLogin()
                //로그인 페이지
                .loginPage("/auth/signin")
                // 로그인 수행
                .loginProcessingUrl("/auth/signin")
                // 로그인 후 수행할.
                .defaultSuccessUrl("/board/list")
                // 실패 시 수행할 url
                .failureUrl("/auth/signin")
                // 로그인 시 input name 값.
                .usernameParameter("name")
                .passwordParameter("password")
                .and().headers().xssProtection();
        return http.build();
    }
}
