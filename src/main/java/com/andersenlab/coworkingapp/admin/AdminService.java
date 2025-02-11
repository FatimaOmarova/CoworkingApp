package com.andersenlab.coworkingapp.admin;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public void saveAdmin(Admin admin){
        adminRepository.save(admin);
    }
    public List<Admin> getAdmins(){
        return adminRepository.findAll();
    }
}
