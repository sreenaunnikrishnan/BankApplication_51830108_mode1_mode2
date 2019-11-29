package com.bankapp.web.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@EnableWebSecurity
public class WebSecConfig extends WebSecurityConfigurerAdapter{

	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private BasicAuthenticationEntryPoint authEntryPoint;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService);
	}

	
	@Bean
	public PasswordEncoder getPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/api/user/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/api/transactionlog/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/api/account/**").hasAnyAuthority("ROLE_ADMIN","ROLE_MGR")
		.antMatchers("/api/customer/**").hasAnyAuthority("ROLE_ADMIN","ROLE_MGR")
		.antMatchers("/api/transaction/**").hasAnyAuthority("ROLE_ADMIN","ROLE_MGR","ROLE_CLERK")
		.and().httpBasic().authenticationEntryPoint(authEntryPoint);
		
		
	}


}
