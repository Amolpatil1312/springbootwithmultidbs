package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Customer;
import com.csi.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<Customer> signUp(@Valid @RequestBody Customer customer) {
        return new ResponseEntity<>(customerServiceImpl.signUp(customer), HttpStatus.CREATED);
    }

    @GetMapping("/signin/{email}/{pwd}")
    public ResponseEntity<Boolean> signIn(@PathVariable String email, @PathVariable String pwd) {
        return ResponseEntity.ok(customerServiceImpl.signIn(email, pwd));
    }

    @GetMapping("/findbyid/{custId}")
    public ResponseEntity<Optional<Customer>> findById(@PathVariable int custId) {
        return ResponseEntity.ok(customerServiceImpl.findById(custId));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerServiceImpl.findAll());
    }

    @PutMapping("/update/{custId}")
    public ResponseEntity<Customer> update(@PathVariable int custId, @Valid @RequestBody Customer customer) {
        Customer customer1 = customerServiceImpl.findById(custId).orElseThrow(() -> new RecordNotFoundException("Customer ID Does not exist"));

        customer1.setCustPassword(customer.getCustPassword());
        customer1.setCustName(customer.getCustName());
        customer1.setCustDOB(customer.getCustDOB());
        customer1.setCustAddress(customer.getCustAddress());
        customer1.setCustEmailId(customer.getCustEmailId());
        customer1.setCustAccountBalance(customer.getCustAccountBalance());

        return new ResponseEntity<>(customerServiceImpl.update(customer1), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletebyid/{custId}")
    public ResponseEntity<String> deleteById(@PathVariable int custId) {
        customerServiceImpl.deleteById(custId);

        return ResponseEntity.ok("Data Deleted Successfully");
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteAll() {
        customerServiceImpl.deleteAll();

        return ResponseEntity.ok("All Data Deleted Successfully");
    }

    @PostMapping("/savebulkofdata")
    public ResponseEntity<List<Customer>> saveBulkOfData(@Valid @RequestBody List<Customer> customerList){
        return new ResponseEntity<>(customerServiceImpl.saveBulkOfData(customerList), HttpStatus.CREATED);
    }
}
