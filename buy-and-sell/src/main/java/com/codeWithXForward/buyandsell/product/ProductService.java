package com.codeWithXForward.buyandsell.product;

import com.codeWithXForward.buyandsell.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product getProduct(Long id){
        return productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("product not found"));
    }
    public Product addProduct(Product product){
        return productRepository.save(product);
    }
    public Product updateProduct(Long id, Product product){
        Product product1 = product;
        productRepository.updateNameAndDescriptionAndPriceByProduct_id(product1.getName(),product1.getDescription(),product1.getPrice(),id);
        return product1;
    }
    public void deleteItem(Long id){
        productRepository.deleteById(id);
    }
    public Product updateUserId(Product product,Long id){
        productRepository.save(product);
        return product;
    }

//    public List<Product> getUserProducts(Long id) {
//        return productRepository.findByCustomer_id(id);
////        return productRepository.findAllById(Collections.singleton(id));
//    }
}
