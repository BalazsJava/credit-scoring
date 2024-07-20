package com.app.creditscoring.api.customer;

import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final SimpMessagingTemplate simpMessagingTemplate;

    public CustomerController(CustomerRepository customerRepository,
                              SimpMessagingTemplate simpMessagingTemplate) {
        this.customerRepository = customerRepository;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @GetMapping("/customer")
    public String addCustomer(@ModelAttribute(name = "customer") Customer customer) {
        return "addCustomerPage";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/customer")
    public void saveCustomer(@ModelAttribute(name = "customer") Customer customer) {
        long id = customerRepository.save(customer);

        // The database generated the ID
        // Constructing result customer with it
        Customer customerToDisplay = new Customer(id, customer);
        simpMessagingTemplate.convertAndSend("/table/customers", customerToDisplay);
    }

//    @PostMapping("/validate")
//    public ResponseEntity<?> validateForm(@RequestBody Customer user) {
//        ValidationError errors = new ValidationError();
//
//        if (username == null || username.isEmpty()) {
//            errors.addError("username", "Username is required.");
//        }
//        if (email == null || email.isEmpty()) {
//            errors.addError("email", "Email is required.");
//        } else if (!email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
//            errors.addError("email", "Please enter a valid email address.");
//        }
//
//        if (errors.hasErrors()) {
//            return ResponseEntity.badRequest().body(errors);
//        }
//
//        return ResponseEntity.ok().build();
//    }

//    @GetMapping("/hello")
//    public String hello(Model model) {
//        model.addAttribute("message", "Hello World!");
//        return "x";
//    }

//    @GetMapping("/customer/{customerId}")
//    public String y(@PathVariable(value = "customerId") String customerId,
//                    @ModelAttribute(name = "newCustomer") Customer customer) {
//        return "y";
//    }
}