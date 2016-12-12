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
}
