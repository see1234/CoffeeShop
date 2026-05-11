package org.example.coffeeshop.config;

import org.example.coffeeshop.repository.AppUserRepository;
import org.example.coffeeshop.service.UserService;
import org.example.coffeeshop.web.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDefaultUser(AppUserRepository userRepository, UserService userService) {
        return args -> {
            if (!userRepository.existsByUsername("manager")) {
                RegisterRequest request = new RegisterRequest();
                request.setUsername("manager");
                request.setPassword("coffee123");
                userService.register(request);
            }
        };
    }
}
