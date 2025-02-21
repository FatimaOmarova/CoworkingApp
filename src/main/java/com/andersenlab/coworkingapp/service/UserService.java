package com.andersenlab.coworkingapp.service;

import com.andersenlab.coworkingapp.entity.User;
import com.andersenlab.coworkingapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> viewUser(){
        return userRepository.findAll();
    }
}
