package com.andersenlab.coworkingapp.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void saveCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public List<Customer> viewCustomer(){
        return customerRepository.findAll();
    }
}
