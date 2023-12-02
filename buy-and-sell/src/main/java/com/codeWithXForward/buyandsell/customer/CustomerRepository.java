package com.codeWithXForward.buyandsell.customer;

import com.codeWithXForward.buyandsell.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Transactional
    @Modifying
    @Query("update Customer c set c.product = ?1 where c.customer_id = ?2")
    int updateProductByCustomer_id(Product product, Long customer_id);
    @Transactional
    @Modifying
    @Query("update Customer c set c.product = ?1")
    int updateProductBy(Product product);
    boolean existsByEmail(String email);
    @Query("select c from Customer c where c.customer_id = ?1")
    Customer findByCustomer_id(Long customer_id);


    Optional<Customer> findByEmail(String email);
}
