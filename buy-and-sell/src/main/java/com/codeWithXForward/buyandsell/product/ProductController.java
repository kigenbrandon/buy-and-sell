package com.codeWithXForward.buyandsell.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")

public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Product>> getProduct(){
        List<Product> allItems = productService.getAllProducts();
        return new ResponseEntity<>(allItems,HttpStatus.OK);
    }
    @GetMapping(value = "{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
       Product item = productService.getProduct(id);
        return new ResponseEntity<>(item,HttpStatus.OK);
    }
//    @GetMapping("user-product/{id}")
//    public ResponseEntity<List<Product>> getUserListing(@PathVariable Long id){
////        List<Product> allItems = productService.getUserProducts(id);
//        return new ResponseEntity<>(allItems,HttpStatus.OK);
//    }
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product newProduct ){
        Product product = productService.addProduct(newProduct);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product update){
        Product product = productService.updateProduct(id,update);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @DeleteMapping(value="{id}")
    public  ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        productService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
