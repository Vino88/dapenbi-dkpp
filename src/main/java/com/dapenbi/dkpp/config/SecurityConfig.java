package com.dapenbi.dkpp.config;

import com.dapenbi.dkpp.dao.UserDao;
import com.dapenbi.dkpp.util.BCryptHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDao userDao;

    @Autowired
    AuthenticationFailureHandler eventAuthenticationFailureHandler;

    private final BCryptHash passwordEncoder = new BCryptHash();

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.headers().frameOptions().sameOrigin().and()
            .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers("/auth/**", "/assets/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .failureHandler(eventAuthenticationFailureHandler)
                .loginPage("/auth/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .failureUrl("/auth/login?error=true")
                .defaultSuccessUrl("/", true)
                .permitAll()
                .and()
            .rememberMe()
                .key("s3cr3tKEY")
                .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"))
                .logoutSuccessUrl("/auth/login")
                .deleteCookies("JSESSIONID")
                .permitAll();
    }

    @Override
    public void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDao)
            .passwordEncoder(getPasswordEncoder());
    }
}
