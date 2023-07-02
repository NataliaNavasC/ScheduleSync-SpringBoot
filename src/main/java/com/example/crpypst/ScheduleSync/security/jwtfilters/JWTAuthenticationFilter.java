package com.example.crpypst.ScheduleSync.security.jwtfilters;

import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.crpypst.ScheduleSync.model.user.Student;
import com.example.crpypst.ScheduleSync.model.user.User;
import com.example.crpypst.ScheduleSync.utils.constants.SecurityConstants;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
    
    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("FILTROOOOOO AUTHHHHHHHHHHHHHHHHHH");
        try {
            Student credentials = new ObjectMapper().readValue(request.getInputStream(), Student.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword(), new ArrayList<>()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
    Authentication auth) throws IOException, ServletException{
        final String authorities = auth.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(","));
        
        final Map<String, Object> claims = new HashMap<>();
        claims.put("Authorities", authorities);

        Key key = new SecretKeySpec(SecurityConstants.SUPER_SECRET_KEY.getBytes(), "HS512");

        String token = Jwts.builder()
            .setIssuedAt(new Date())
            .setIssuer(SecurityConstants.ISSUER_INFO)
            .setClaims(claims)
			.setSubject(((org.springframework.security.core.userdetails.User)auth.getPrincipal()).getUsername())
			.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.TOKEN_EXPIRATION_TIME))
            .signWith(key, SignatureAlgorithm.HS512)
            .compact();

		response.addHeader(SecurityConstants.HEADER_AUTHORIZATION_KEY, SecurityConstants.TOKEN_BEARER_PREFIX + token);
    }
}
