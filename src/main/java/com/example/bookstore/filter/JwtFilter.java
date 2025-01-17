package com.example.bookstore.filter;//package com.example.bookstore.filter;
//
//import com.example.bookstore.util.JwtUtil;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.AllArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//@AllArgsConstructor
//public class JwtFilter extends OncePerRequestFilter {
//   // need to check whether the user is existing in the database or not
//   private UserDetailsService userDetailsService;
//   private JwtUtil jwtUtil;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
////        implement the filter logic here for parsing jwt token and validate if token related to an existing user
//        String authorizationHeader = request.getHeader("Authorization");
//        String token ;
//        String userName;
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            token = authorizationHeader.substring(7);
//            userName = jwtUtil.extractUsername(token);
//        }
////        else if (!authorizationHeader.startsWith("Bearer ")) {
////            throw new UsernameNotFoundException("Invalid authorization");
////        }
//        else{
//            userName = null;
//            token = null;
//        }
//        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
//            if (jwtUtil.isTokenValid(token, userDetails.getUsername())) {
//                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
//                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                usernamePasswordAuthenticationToken
//                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//            }
//        }
//    }
//}
