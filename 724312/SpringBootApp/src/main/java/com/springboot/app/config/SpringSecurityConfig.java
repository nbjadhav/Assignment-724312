package com.springboot.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.springboot.app.util.Constants;

/**
 * 
 * This is the Spring Security Configuration class which holds the basic security
 * configuration for all the end points
 *
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles(Constants.USER).and().withUser("admin")
				.password("{noop}password").roles(Constants.USER, Constants.ADMIN);
	}

	// Secure the endpoins with HTTP Basic authentication
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.GET, "/api/subscriptions").hasRole(Constants.USER)
				.antMatchers(HttpMethod.GET, "/api/subscription/**").hasRole(Constants.USER)
				.antMatchers(HttpMethod.POST, "/api/subscriptions").hasRole(Constants.ADMIN)
				.antMatchers(HttpMethod.PUT, "/api/subscription/**").hasRole(Constants.ADMIN).and().csrf().disable().formLogin()
				.disable();
	}
}