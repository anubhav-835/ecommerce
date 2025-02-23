package anubhav.restservice.customer_management.restcontroller;

import anubhav.restservice.customer_management.entity.Customer;
import anubhav.restservice.customer_management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/signup")
    public String signUp(@RequestBody Customer customer) {
        if (customerService.findByUsername(customer.getUsername()) != null) {
            return "Username already exists.";
        }
        if (customerService.findByEmail(customer.getEmail()) != null) {
            return "Email already exists.";
        }
        customerService.saveCustomer(customer);
        return "Account created successfully!";
    }

    @PostMapping("/signin")
    public String signIn(@RequestBody Customer customer) {
        Customer existingCustomer = customerService.findByUsername(customer.getUsername());
        if (existingCustomer != null && customer.getPassword().equals(existingCustomer.getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid username or password.";
        }
    }
}
