package com.app.creditscoring.api.customer.swagger;

import com.app.creditscoring.api.customer.Customer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Tag(name = "Customer API", description = "Operations related to customers")
public interface CustomerApiDocumentation {

    @Operation(summary = "Redirect to the new customer page",
            description = "Redirects to the HTML page for adding a new customer")
    RedirectView getNewCustomerPage();

    @Operation(summary = "Save a new customer",
            description = "Saves a new customer and returns the saved entity")
    @ApiResponse(responseCode = "200", description = "Customer saved successfully")
    Customer saveCustomer(@Parameter(description = "Customer object to be saved", required = true)
                          @RequestBody Customer customer);

    @Operation(summary = "Delete a customer by ID",
            description = "Deletes the customer with the specified ID")
    @ApiResponse(responseCode = "204", description = "Customer deleted successfully")
    void deleteCustomerById(@Parameter(description = "ID of the customer to delete", required = true)
                            @RequestParam("id") long id);

    @Operation(summary = "Get a customer by ID",
            description = "Retrieves the customer with the specified ID")
    @ApiResponse(responseCode = "200", description = "Customer retrieved successfully")
    @ApiResponse(responseCode = "404", description = "Customer not found")
    Customer getCustomerById(@Parameter(description = "ID of the customer to retrieve", required = true)
                             @PathVariable("id") long id);

    @Operation(summary = "Get all customers",
            description = "Retrieves a list of all customers")
    @ApiResponse(responseCode = "200", description = "List of customers retrieved successfully")
    List<Customer> getAllCustomers();
}