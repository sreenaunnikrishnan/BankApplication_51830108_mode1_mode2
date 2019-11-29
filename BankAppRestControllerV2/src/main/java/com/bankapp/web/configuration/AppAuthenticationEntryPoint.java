package com.bankapp.web.configuration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AppAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	@Override
	public void afterPropertiesSet(){
		
		setRealmName("myApp");

	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		response.addHeader("WWW-Authenticate", "Basic realm=\"" + this.getRealmName() + "\"");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter out=response.getWriter();
		out.print("401-UNAUTHORIZED - contact lia@l.com");

	}
	
	

}
