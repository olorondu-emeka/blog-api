package com.emeka.blogspringboot;

import com.emeka.blogspringboot.services.AdminUserDetailsService;
import com.emeka.blogspringboot.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    AdminUserDetailsService adminUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService)
                .and()
                .userDetailsService(adminUserDetailsService);

    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/authenticate")
//                .antMatchers("/api/admin")
                .permitAll();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
//        return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }
}
