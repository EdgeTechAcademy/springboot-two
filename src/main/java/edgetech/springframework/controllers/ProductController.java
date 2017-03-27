package edgetech.springframework.controllers;

import edgetech.springframework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ProductController {

	//	Use a service for when things get complicated.
	//	more than just doing a findAll or delete
	//	the project has a great great example I think
	//	spring-boot-sample-data-jpa
	//	spring-boot/spring-boot-samples/spring-boot-sample-data-jpa/
	//		it is in the spring-boot-master zip file in the download folder!!!!!
	//			this has been copied to the Projects/spring-boot-master folder
	//		I need to review this !!!

	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "/products", method = GET)
	public String list(Model model){
		model.addAttribute("products", productService.listAllProducts());
		System.out.println("Returning products:");
		return "products";
	}

	@RequestMapping("product/{id}")
	public String showProduct(@PathVariable Integer id, Model model){
		if ( productService.getProductById(id) != null ) {
			model.addAttribute("product", productService.getProductById(id));
			return "productshow";
		}
		else return "404";
	}
}
