package com.example.crpypst.ScheduleSync.security.jwtfilters;

import java.io.IOException;
import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.example.crpypst.ScheduleSync.utils.constants.SecurityConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter{

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(SecurityConstants.HEADER_AUTHORIZATION_KEY);
		if (token != null) {
            // Se procesa el token y se recupera el nombre de usuario.
			Claims body = Jwts.parserBuilder()
            .setSigningKey(getSignInkey())
            .build()
            .parseClaimsJws(token.replace(SecurityConstants.TOKEN_BEARER_PREFIX, ""))
            .getBody();
            String user = body.getSubject();
            
			if (user != null) {
                final Collection<SimpleGrantedAuthority> authorities =
                Arrays.stream(body.get("Authorities").toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
                
                return new UsernamePasswordAuthenticationToken(user, null, authorities);
			}
			return null;
		}
		return null;
	}

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(SecurityConstants.HEADER_AUTHORIZATION_KEY);
        if (header == null || !header.startsWith(SecurityConstants.TOKEN_BEARER_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private Key getSignInkey(){
        byte[] keyByres = Decoders.BASE64.decode(SecurityConstants.SUPER_SECRET_KEY);
        return Keys.hmacShaKeyFor(keyByres);
    }
}
