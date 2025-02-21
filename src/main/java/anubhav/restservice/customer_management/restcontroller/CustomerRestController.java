package anubhav.restservice.customer_management.restcontroller;

import anubhav.restservice.customer_management.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CustomerRestController {

        @Autowired
        private CustomerService userService;

        @PostMapping("/signup")
        public ResponseEntity<String> registerUser(@RequestBody Customer user) {
            String response = userService.registerUser(user);
            if (response.equals("User already exists")) {
                return ResponseEntity.status(409).body(response);
            }
            return ResponseEntity.ok(response);
        }

        @PostMapping("/signin")
        public ResponseEntity<Customer> signInUser(@RequestBody Customer user) {
            try {
                Customer authenticatedUser = userService.authenticateUser(user.getUseremail(), user.getPassword());
                return ResponseEntity.ok(authenticatedUser);
            } catch (RuntimeException e) {
                return ResponseEntity.status(401).body(null);
            }
        }
}
