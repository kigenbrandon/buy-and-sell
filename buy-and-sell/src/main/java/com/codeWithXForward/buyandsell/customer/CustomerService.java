package com.codeWithXForward.buyandsell.customer;

import com.codeWithXForward.buyandsell.exception.UserFoundException;
import com.codeWithXForward.buyandsell.product.Product;
import com.codeWithXForward.buyandsell.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDTOMapper customerDTOMapper;
    private final ProductRepository productRepository;


    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerDTOMapper customerDTOMapper, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.customerDTOMapper = customerDTOMapper;
        this.productRepository = productRepository;
    }


    public List<CustomerDTO> getCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerDTOMapper).collect(Collectors.toList());
    }
    public Customer saveCustomer(Customer customer){
        if (customerRepository.existsByEmail(customer.getEmail())){
            throw new UserFoundException("email exists");
        }
        return customerRepository.save(customer);
    }
    public Product saveCustomerProduct(Long id, Customer customer){
        customerRepository.updateProductByCustomer_id(customer.getProduct().set(0,new Product()), id);

        return (Product) customer.getProduct().stream().collect(Collectors.toList());
    }


}
