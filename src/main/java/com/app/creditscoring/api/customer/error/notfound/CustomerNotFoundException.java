package com.app.creditscoring.api.customer.error.notfound;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(long id) {
        super("Customer not found. ID:[%s]".formatted(id));
    }

}