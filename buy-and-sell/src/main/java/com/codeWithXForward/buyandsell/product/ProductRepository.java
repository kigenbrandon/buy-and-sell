package com.codeWithXForward.buyandsell.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
//    @Query("select p from Product p where p.customer_id = ?1")
//    List<Product> findByCustomer_id(Long customer_id);
    @Transactional
    @Modifying
    @Query("update Product p set p.name = ?1, p.description = ?2, p.price = ?3 where p.product_id = ?4")
    int updateNameAndDescriptionAndPriceByProduct_id(String name, String description, Double price, Long product_id);

}
