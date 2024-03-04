package com.csi.service;

import com.csi.model.Customer;
import com.csi.repo.customer.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl {

    @Autowired
    private CustomerRepo customerRepoImpl;

    public Customer signUp(Customer customer) {
        return customerRepoImpl.save(customer);


    }

    public Optional<Customer> findById(int custId) {
        return customerRepoImpl.findById(custId);
    }

    public List<Customer> findAll() {
        return customerRepoImpl.findAll();
    }

    public boolean signIn(String email, String password) {


        boolean flag = false;

        for (Customer customer : findAll()) {
            if (customer.getCustEmailId().equals(email) && customer.getCustPassword().equals(password)) {
                flag = true;
            }


        }

        return flag;
    }


    public Customer update(Customer customer) {
        return customerRepoImpl.save(customer);
    }


    public void deleteById(int custId) {
        customerRepoImpl.deleteById(custId);
    }

    public void deleteAll() {
        customerRepoImpl.deleteAll();
    }

    public List<Customer> saveBulkOfData(List<Customer> customerList) {

        return customerRepoImpl.saveAll(customerList);
    }
}
