package com.andersenlab.coworkingapp.admin;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("save/admin")
    public void saveAdmin(@RequestBody Admin admin){
        adminService.saveAdmin(admin);
    }
    @GetMapping("view/admin")
    public List<Admin> viewAdmin(){
        return adminService.getAdmins();
    }

}

