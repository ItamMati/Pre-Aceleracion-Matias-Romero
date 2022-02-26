package com.preAceleracionAlkemy.preAceleracion.auth.filter;

import com.preAceleracionAlkemy.preAceleracion.auth.service.UserDetailsCustomService;
import com.preAceleracionAlkemy.preAceleracion.auth.service.JwtUtils;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    
    @Autowired
    private UserDetailsCustomService userDetailsCustomService;
    
    @Autowired
    private JwtUtils jwtUtil;
 
    private AuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        
        final String authorizationHeader = request.getHeader("Authorization");
        
        String username = null;
        String jwt = null;
        
        
        
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            
            jwt = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
        }
        
        if(username != null && SecurityContextHolder.getContext()== null){
            
            UserDetails userDetails = userDetailsCustomService.loadUserByUsername(username);
            
            if(jwtUtil.validateToken(jwt, userDetails)){
                
                UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(userDetails.getUsername(),userDetails.getPassword());
            
               Authentication auth = authenticationManager.authenticate(authReq);
                
                SecurityContextHolder.getContext().setAuthentication(auth);
            
            }
        }
        
        filterChain.doFilter(request,response);
        
        
    }
    
}
