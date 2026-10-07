package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/customers")
public class CustomerController {
  @GetMapping("/{id}")
  public Customer getFromId(@PathVariable Long id) {
    Address address = new Address(
      "street",
      "city",
      "postcode"
    );

    return new Customer(
      id,
      "name",
      "email",
      address
    ); 
  }
}
