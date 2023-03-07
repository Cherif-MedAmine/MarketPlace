package tn.esprit.marketplace.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;
import tn.esprit.marketplace.services.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
public class JWTAuthorizationFilter extends OncePerRequestFilter {


    private static final String HEADER_STRING = "Authorization";
    private UserService userService;

    public JWTAuthorizationFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

            String header = request.getHeader("Authorization");

            if (header == null || !header.startsWith("Bearer ")) {
                // If the Authorization header is missing or does not start with "Bearer ", reject the request with a 401 Unauthorized response
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid or missing Authorization header");
                return;
            }

            // Extract the JWT token from the Authorization header
            String token = header.substring(7);

            try {
                // Validate the token using the secret key
                Jws<Claims> claims = Jwts.parser().setSigningKey("SecretKey".getBytes()).parseClaimsJws(token);

                // Get the username from the token's subject claim
                String username = claims.getBody().getSubject();

                // Create an authentication object for the authenticated user
             //   UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            //    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                // Set the authentication object in the security context
             //   SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (JwtException | UsernameNotFoundException e) {
                // If the token is invalid or the user cannot be found, reject the request with a 401 Unauthorized response
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid or expired token");
                return;
            }

            // Continue the filter chain
            filterChain.doFilter(request, response);
        }


    public Boolean validateToken(String token) {
        Assert.notNull(userService.loadUserByUsername(JWTUtils.extractUsername(token)),
                "User Doesn't exist");
        Assert.notNull(JWTUtils.isTokenExpired(token), "Token is Expired");
        return true;
    }

    private class HEADER_STRING {
    }
}
