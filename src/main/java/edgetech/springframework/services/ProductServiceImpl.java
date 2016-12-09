package edgetech.springframework.services;

import edgetech.springframework.domain.Product;
import edgetech.springframework.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

    @Override
    public Iterable<Product> listAllProducts() {
        return productRepository.findAll();
    }

	@Override
    public Product getProductById(Integer id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
    	Product	product = productRepository.findOne(id);
        productRepository.delete(product);
    }

	@Override
	public Iterable<Product> listOddProducts() {
		Iterable<Product> products = productRepository.findAll();
		for(Iterator<Product> prodIterator = products.iterator(); prodIterator.hasNext();) {
			Product prod = prodIterator.next();
			if ((prod.getId() & 1) == 0)      	// if the Id is Even
				prodIterator.remove();			//	remove from our list
		}
		return products;
	}
}
