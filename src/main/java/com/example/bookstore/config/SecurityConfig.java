package com.example.bookstore.config;
//
//import com.example.bookstore.filter.JwtFilter;
//import com.example.bookstore.service.CustomUserDetailsService;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfig {
//
//    private final CustomUserDetailsService userDetailsService;
//
//    private final JwtFilter jwtFilter;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/auth/**").permitAll() // Public access for auth routes
//                        .anyRequest().authenticated()
//                ).addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
////                .httpBasic(withDefaults())
////                .logout(logout -> logout
////                        .logoutUrl("/api/auth/logout")
////                        .invalidateHttpSession(true)
////                        .deleteCookies("JSESSIONID")
////                        .logoutSuccessHandler((request, response, authentication) -> {
////                            response.setStatus(HttpServletResponse.SC_OK);
////                        })
////                )
//                ;
//        return http.build();
//    }
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder =
//                http.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
//        return authenticationManagerBuilder.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
