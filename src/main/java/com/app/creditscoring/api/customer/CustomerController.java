package com.app.creditscoring.api.customer;

import com.app.creditscoring.api.customer.error.notfound.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
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

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/customer")
    public void deleteCustomerById(@RequestParam("id") long id) {
        customerRepository.deleteById(id);
    }

    @ResponseBody
    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable("id") long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @ResponseBody
    @GetMapping("/customer/all")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

}