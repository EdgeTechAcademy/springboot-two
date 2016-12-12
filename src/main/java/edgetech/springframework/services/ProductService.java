package edgetech.springframework.services;


import edgetech.springframework.domain.Product;

public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);
}
