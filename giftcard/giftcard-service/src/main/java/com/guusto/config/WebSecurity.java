package com.guusto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled =true)
public class WebSecurity extends WebSecurityConfigurerAdapter {

    public CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    public CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
//    public CustomSuccessHandler customSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/assets/**").permitAll()
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .usernameParameter("j_username")
                .passwordParameter("j_password")
            .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .successHandler(customAuthenticationSuccessHandler)
                .failureHandler(customAuthenticationFailureHandler)
            .permitAll()
            .and()
                .logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .and()
            .csrf();
    }
}
