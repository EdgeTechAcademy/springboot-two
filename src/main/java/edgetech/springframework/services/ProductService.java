package edgetech.springframework.services;

import edgetech.springframework.domain.Product;
import edgetech.springframework.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * Created by Edge Tech Academy on 12/12/2016.
 */
@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> listAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepository.findOne(id);
    }

	//	These items have been added for the new functionality
	//		to make our app a richer MVC example
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public void deleteProduct(Integer id) {
		Product    product = productRepository.findOne(id);
		productRepository.delete(product);
	}

	public Iterable<Product> listOddProducts() {
		Iterable<Product> products = productRepository.findAll();
		for(Iterator<Product> prodIterator = products.iterator(); prodIterator.hasNext();) {
			Product prod = prodIterator.next();
			if ((prod.getId() & 1) == 0)		// if the Id is Even
				prodIterator.remove();			// remove from our list
		}
		return products;
	}
}
