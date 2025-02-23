package anubhav.restservice.customer_management.jparepo;

import org.springframework.data.jpa.repository.JpaRepository;
import anubhav.restservice.customer_management.entity.Customer;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByUsername(String username);
    Optional<Customer> findByEmail(String email);
}
