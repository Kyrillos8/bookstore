package com.example.bookstore.service;
//
//import com.example.bookstore.entity.User;
//import com.example.bookstore.repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    public CustomUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByUsername(username);
//        if (!user.isPresent()) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return org.springframework.security.core.userdetails.User.builder()
//                .username(user.get().getUsername())
//                .password(user.get().getPassword())
//                .roles("USER")
//                .build();
//    }
//}
