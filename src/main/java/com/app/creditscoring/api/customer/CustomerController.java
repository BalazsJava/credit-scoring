package com.app.creditscoring.api.customer;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customer")
    public RedirectView getNewCustomerPage() {
        // By default, Spring looks for the file path within: src/main/resources/static/...
        return new RedirectView("html/addCustomerPage.html");
    }

    @ResponseBody
    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody Customer customer) {
        long id = customerRepository.save(customer);

        // The database generated the ID
        // Constructing result customer with it
        return new Customer(id, customer);
    }

    @ResponseBody
    @GetMapping("/customer/all")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

}