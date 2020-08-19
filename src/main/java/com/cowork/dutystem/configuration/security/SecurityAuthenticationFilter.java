package com.cowork.dutystem.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String username = "test";
        UserDetails authentication = customUserDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(authentication.getUsername(), null, null); //여기있는 super.setAuthenticated(true); 를 타야함.
        SecurityContextHolder.getContext().setAuthentication(auth);
        filterChain.doFilter(request, response);
    }
}
