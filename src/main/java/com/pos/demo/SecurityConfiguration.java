package com.pos.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@SuppressWarnings("deprecation")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		.antMatchers("/report").hasRole("ADMIN")
		.antMatchers("/item").hasRole("ADMIN")// for viewing reports and editing menu items 
		.antMatchers("/reports").hasRole("OWNER")
		.antMatchers("/reports").hasRole("OWNER")
		.antMatchers("/expenses").hasRole("OWNER")
		// for adding new employees
		.antMatchers("/orders").hasAnyRole("CHEF","OWNER","CASHIER")//for viewing order Status
		.antMatchers("/customer").hasAnyRole("OWNER","CASHIER")// for adding new customers
		.antMatchers("/admin").permitAll()
		.antMatchers("/users").permitAll()
		.antMatchers("/").permitAll()
		.and().formLogin();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
