package com.pos.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		.antMatchers("/reports/**").hasRole("OWNER")
		.antMatchers("/expenses/**").hasAnyRole("OWNER","CASHIER")
		.antMatchers("/billing/**").hasAnyRole("OWNER","CASHIER")
		.antMatchers(HttpMethod.POST,"/reports").hasAnyRole("ADMIN","OWNER")
		.antMatchers("/item/**").hasAnyRole("ADMIN","OWNER")// for viewing reports and editing menu items 
		.antMatchers(HttpMethod.POST,"/items").hasAnyRole("ADMIN","OWNER")
		// .antMatchers("/admin/**").hasAnyRole("ADMIN","OWNER")// for adding new employees
		.antMatchers(HttpMethod.POST,"/users").hasAnyRole("ADMIN","OWNER")
		.antMatchers("/orders/**").hasAnyRole("CHEF","OWNER","CASHIER")//for viewing order Status
		.antMatchers(HttpMethod.POST,"/orders/**").hasAnyRole("CHEF","OWNER","CASHIER")
		.antMatchers(HttpMethod.PUT,"/orders/**").hasAnyRole("CHEF","OWNER","CASHIER")
		.antMatchers("/customer/**").hasAnyRole("OWNER","CASHIER")// for adding new customers
		.antMatchers(HttpMethod.POST,"/cust").hasAnyRole("OWNER","CASHIER")
		.antMatchers("/").permitAll()
		.and().formLogin();
		http.csrf().disable();  
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
}
