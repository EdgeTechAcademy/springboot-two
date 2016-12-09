package edgetech.springframework.services;


import edgetech.springframework.domain.Product;

public interface ProductService {
    Iterable<Product> listAllProducts();

    Iterable<Product> listOddProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}
