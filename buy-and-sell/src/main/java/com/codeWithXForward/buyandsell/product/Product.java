package com.codeWithXForward.buyandsell.product;

import com.codeWithXForward.buyandsell.customer.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Setter
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long product_id;
    private String name;
    private String description;

    private Double price;

    public Product(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
//    private Long getCustomerId() {
//        Customer customer = new Customer();
//        return customer.getCustomer_id();
//    }

    public Long getId() {
        return getProduct_id();
    }
}
