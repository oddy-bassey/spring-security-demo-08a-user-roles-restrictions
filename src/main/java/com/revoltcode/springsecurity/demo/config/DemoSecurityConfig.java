package com.revoltcode.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	//overriden method that configures users(in memory, database, idap, etc)
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//add users for in memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder(); 
		
		auth.inMemoryAuthentication()
		.withUser(users.username("David").password("test123").roles("EMPLOYEE"))
		.withUser(users.username("Otto").password("test123").roles("EMPLOYEE","MANAGER"))
		.withUser(users.username("Susan").password("test123").roles("EMPLOYEE","ADMIN"));
	}

	//overriden method that configures security of web paths in application, login, logout etc
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/leaders/**").hasRole("MANAGER")
			.antMatchers("/systems/**").hasRole("ADMIN")
			.and()
			.formLogin()
			.loginPage("/showMyLoginPage")
			.loginProcessingUrl("/authenticateTheUser")
			.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling()
			.accessDeniedPage("/access-denied");
	}
}













