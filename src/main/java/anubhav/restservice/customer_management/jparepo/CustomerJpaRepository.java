package anubhav.restservice.customer_management.jparepo;

import anubhav.restservice.customer_management.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<Customer,Long> {
}
