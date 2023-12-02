package com.codeWithXForward.buyandsell.Product;

import com.codeWithXForward.buyandsell.product.Product;
import com.fasterxml.jackson.core.json.JsonReadContext;
import org.apache.tomcat.util.json.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductControllerTest {


    @Test
    void canGetAllProducts() {
//        Testing products api
        RestTemplate template = new RestTemplate();
      ResponseEntity s =  template.getForObject("http://127.0.0.1:8080/api/v1/product/all", ResponseEntity.class,"application/json");
//      Testing product api
        RestTemplate template2 = new RestTemplate();
        ResponseEntity s2 =  template.getForObject("http://127.0.0.1:8080/api/v1/product/1", ResponseEntity.class,"application/json");

      //        System.out.println(s);
////        assertEquals(,s);
    }
}