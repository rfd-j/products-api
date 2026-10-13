package uk.ac.westminster.products_api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ProductController {
  @Autowired 
  private ProductService productService;

  @GetMapping("/products")
  public List<Product> getallProducts() {
    return productService.getAllProducts();
  }

  @GetMapping("/products/{id}")
  public Product getProductById(@PathVariable Long id) {
    return productService.getProductById(id).orElse(null);
  }

  @GetMapping("/products/search")
  public List<Product> searchProductsByName(@RequestParam String name) {
    return productService.getProductByName(name);
  }

  @PostMapping("/products")
  public Product addProduct(@RequestBody Product product) {
    return productService.addProduct(product);
  }

  @DeleteMapping("/products/{id}")
  public void deleteProduct(@PathVariable Long id) {
    productService.deleteProduct(id);
  }
}
