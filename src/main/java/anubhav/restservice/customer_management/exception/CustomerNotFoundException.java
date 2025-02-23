package anubhav.restservice.customer_management.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String email) {
        super("Customer not found "+email);
    }
}
