package br.com.jamesmayke.vacancy_management_system.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.jamesmayke.vacancy_management_system.providers.JWTProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private JWTProvider jwtProvider;

    @Override
    protected void doFilterInternal(
        @SuppressWarnings("null") HttpServletRequest request, 
        @SuppressWarnings("null") HttpServletResponse response, 
        @SuppressWarnings("null") FilterChain filterChain) throws ServletException, IOException {
        
        // SecurityContextHolder.getContext().setAuthentication(null);  

        String header = request.getHeader("Authorization");

        if (request.getRequestURI().startsWith("/company")) {
            if (header != null) {
                var token = this.jwtProvider.validateToken(header);
     
                if (token == null) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }
    
                request.setAttribute("company_id", token.getSubject());

                var roles = token.getClaim("roles").asList(Object.class);
                var grants = roles.stream().map(
                    role -> new SimpleGrantedAuthority("ROLE_" + role.toString())
                ).toList();
    
                UsernamePasswordAuthenticationToken auth = 
                new UsernamePasswordAuthenticationToken(
                    token.getSubject(), null, grants);
                
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        filterChain.doFilter(request, response);
    }
    
}
