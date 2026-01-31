package com.usermanagement.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        System.out.println(">>> JwtFilter CALLED <<<");

        String header = request.getHeader("Authorization");
        System.out.println("hahaha" + header);
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);

            try {
                String username = jwtUtil.getUsername(token);
                String role = jwtUtil.getRole(token);
                System.out.println("RAW JWT -> username=" + username + ", role=" + role);
                if (username != null
                        && role != null
                        && SecurityContextHolder.getContext().getAuthentication() == null) {

                    // ⭐ CHUẨN HÓA ROLE
                    String authority = role.startsWith("ROLE_")
                            ? role
                            : "ROLE_" + role;

                    // ⭐ IN RA AUTHORITY CUỐI
                    System.out.println("FINAL AUTHORITY = " + authority);

                    List<SimpleGrantedAuthority> authorities =
                            List.of(new SimpleGrantedAuthority(authority));
                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(
                                    username,
                                    null,
                                    authorities
                            );

                    authToken.setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(request)
                    );

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }

            } catch (Exception e) {
                System.out.println("JWT ERROR: " + e.getMessage());
            }
        }

        filterChain.doFilter(request, response);
    }
}
