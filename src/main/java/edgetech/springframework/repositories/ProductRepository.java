package edgetech.springframework.repositories;

import edgetech.springframework.domain.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Edge Tech Academy on 11/22/2016.
 */

public interface ProductRepository extends CrudRepository<Product, Integer>{
}
