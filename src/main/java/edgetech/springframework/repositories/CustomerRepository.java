package edgetech.springframework.repositories;

import edgetech.springframework.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Edge Tech Academy on 12/2/2016.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
