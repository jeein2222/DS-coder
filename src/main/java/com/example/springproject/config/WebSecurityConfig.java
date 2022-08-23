package com.example.springproject.config;


import com.example.springproject.security.JwtAuthenticationFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.web.filter.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.cors()
           .and()
           .csrf()
               .disable()
           .httpBasic()
                .disable()
           .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
           .and()
           .authorizeRequests()
                .antMatchers("/ds-sw/*","/ds-sw/auth/**","/css/**","/js/**","/fonts/**","/images/**").permitAll()
           .anyRequest()
                .authenticated();
        http.addFilterAfter(
                jwtAuthenticationFilter,
                CorsFilter.class
        );
    }

}
