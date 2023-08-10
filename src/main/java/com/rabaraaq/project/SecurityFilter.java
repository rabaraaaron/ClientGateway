package com.rabaraaq.project;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Profile("security")
@Component
@Order(1)
public class SecurityFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		
		if (uri.startsWith("/api/")) {
			String authheader = req.getHeader("authorization");
			if (authheader != null
					&& authheader.contains("comeonin") 
					&& authheader.contains("Bearer")
					&& authheader.length() >= 15) {
				chain.doFilter(request, response);
				return;
			}

		} else {
			chain.doFilter(request, response);
			return;
		}
	}

}
