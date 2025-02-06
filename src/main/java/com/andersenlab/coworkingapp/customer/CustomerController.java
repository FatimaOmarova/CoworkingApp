package com.andersenlab.coworkingapp.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("save/customer")
    public void saveCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
    }
    @GetMapping("view/customer")
    public List<Customer> viewCustomer(){
        return customerService.viewCustomer();
    }
}
