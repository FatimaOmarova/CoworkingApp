package com.andersenlab.coworkingapp.service;

import com.andersenlab.coworkingapp.entity.User;
import com.andersenlab.coworkingapp.repository.AuthRepository;
import com.andersenlab.coworkingapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String login(String username, String password) {
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return user.getRole();
    }
}

