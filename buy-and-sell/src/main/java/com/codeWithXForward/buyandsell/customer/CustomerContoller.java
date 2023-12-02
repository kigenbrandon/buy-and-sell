package com.codeWithXForward.buyandsell.customer;

import com.codeWithXForward.buyandsell.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerContoller {
    public final CustomerService customerService;
    @Autowired
    public CustomerContoller(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/all")
    public List<CustomerDTO> getCustomers(){
        return customerService.getCustomers();
    }
    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }
    @PutMapping("update-product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id,@RequestBody Customer customer){
        customerService.saveCustomerProduct(id, customer);
        return new ResponseEntity<>(customer.getProduct().stream().findFirst().orElseThrow(), HttpStatus.CREATED);
    }
//    @PostMapping("create-product")
//    public ResponseEntity<Product> createProduct() {
//        customerService.createProduct();
//
//    }

}
