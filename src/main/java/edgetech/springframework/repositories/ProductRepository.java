package edgetech.springframework.repositories;

import edgetech.springframework.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer>{
}
